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

public class StudentSearchController extends HttpServlet {
			
			
@EJB 
IStudentDao StudentDao;
			
			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Conjunction conjuction = Restrictions.conjunction();
				
	

String index_number = req.getParameter("index_number");
	if (index_number != null && !index_number.equals("")){
		if(index_number.endsWith("*")){
			index_number = index_number.replace("*", "%");
			conjuction.add(Restrictions.like("index_number", index_number));
		}else{
			conjuction.add(Restrictions.eq("index_number", index_number));
		}
	}	
	

Integer count_exam_passed = null;
if (req.getParameter("count_exam_passed") != null && !"".equals(req.getParameter("count_exam_passed")) ) {
	String count_exam_passedString = req.getParameter("count_exam_passed");
	boolean count_exam_passedBoolean = false;
	if (count_exam_passedString.endsWith("*")){
		count_exam_passedBoolean = true;
		count_exam_passedString.replace("*", "");
	}
	try{
		count_exam_passed = Integer.parseInt(count_exam_passedString);
		if (count_exam_passedBoolean)
			conjuction.add(Restrictions.like("count_exam_passed", count_exam_passed));
		else
			conjuction.add(Restrictions.eq("count_exam_passed",count_exam_passed));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./StudentSearch.jsp");
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
	RequestDispatcher dispatcher = req.getRequestDispatcher("./SearchStudent.jsp");
	dispatcher.forward(req, resp);
	return;
}
	
	

String genderValue =    req.getParameter("gender");
if(!genderValue.equals("null")){
	Gender gender = Gender.valueOf(req.getParameter("gender"));
	conjuction.add(Restrictions.like("gender", gender));
}
	

						
	List<Student> students;			
	if(size(conjuction.conditions())!=0){
		 students = StudentDao.findBySearchCriteria(conjuction);
	}else{
		 students = StudentDao.findAll();
	}				
	req.setAttribute("students", students);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./StudentSearch.jsp");
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