package controller.search;
		
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Collection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.*;
	
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
		

import dao.*;

public class ProfessorSearchController extends HttpServlet {
			
			
@EJB 
IProfessorDao ProfessorDao;
			
			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Conjunction conjuction = Restrictions.conjunction();
				
	

Integer count_subjests = null;
if (req.getParameter("count_subjests") != null && !"".equals(req.getParameter("count_subjests")) ) {
	String count_subjestsString = req.getParameter("count_subjests");
	boolean count_subjestsBoolean = false;
	if (count_subjestsString.endsWith("*")){
		count_subjestsBoolean = true;
		count_subjestsString.replace("*", "");
	}
	try{
		count_subjests = Integer.parseInt(count_subjestsString);
		if (count_subjestsBoolean)
			conjuction.add(Restrictions.like("count_subjests", count_subjests));
		else
			conjuction.add(Restrictions.eq("count_subjests",count_subjests));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./ProfessorSearch.jsp");
		dispatcher.forward(req, resp);
		return;	
	}	
}
	
	
	


				
	

String firstname = req.getParameter("firstname");
	if (firstname != null && !firstname.equals("")){
		if(firstname.endsWith("*")){
			firstname = firstname.replace("*", "%");
			conjuction.add(Restrictions.like("firstname", firstname));
		}else{
			conjuction.add(Restrictions.eq("firstname", firstname));
		}
	}	
	

String lastname = req.getParameter("lastname");
	if (lastname != null && !lastname.equals("")){
		if(lastname.endsWith("*")){
			lastname = lastname.replace("*", "%");
			conjuction.add(Restrictions.like("lastname", lastname));
		}else{
			conjuction.add(Restrictions.eq("lastname", lastname));
		}
	}	
	

String birthdayString = req.getParameter("birthday");
Date birthday = null;
SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");					
try {
	if(!birthdayString.equals("")){
		birthday = dateFormat.parse(birthdayString);
		conjuction.add(Restrictions.like("birthday", birthday));
	}
} catch (ParseException e) {
	req.setAttribute("badFormat", true);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./SearchProfessor.jsp");
	dispatcher.forward(req, resp);
	return;
}
	
	

String genderValue =    req.getParameter("gender");
if(!genderValue.equals("null")){
	Gender gender = Gender.valueOf(req.getParameter("gender"));
	conjuction.add(Restrictions.like("gender", gender));
}
	

						
	List<Professor> professors;			
	if(size(conjuction.conditions())!=0){
		 professors = ProfessorDao.findBySearchCriteria(conjuction);
	}else{
		 professors = ProfessorDao.findAll();
	}				
	req.setAttribute("professors", professors);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./ProfessorSearch.jsp");
	dispatcher.forward(req, resp);
	return;

}
public int size(Iterable<?> it) {
	  if (it instanceof Collection)
	    return ((Collection<?>)it).size();

	  // else iterate

	  int i = 0;
	  for (Object obj : it) i++;
	  return i;
	}
}	