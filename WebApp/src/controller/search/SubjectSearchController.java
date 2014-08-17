package controller.search;
		
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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

public class SubjectSearchController extends HttpServlet {
			
			
@EJB 
ISubjectDao SubjectDao;
			
			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Conjunction conjuction = Restrictions.conjunction();
				
	

String subjectname = req.getParameter("subjectname");
	if (subjectname != null && !subjectname.equals("")){
		if(subjectname.endsWith("*")){
			subjectname = subjectname.replace("*", "%");
			conjuction.add(Restrictions.like("subjectname", subjectname));
		}else{
			conjuction.add(Restrictions.eq("subjectname", subjectname));
		}
	}	
	

Integer espb = null;
if (req.getParameter("espb") != null && !"".equals(req.getParameter("espb")) ) {
	String espbString = req.getParameter("espb");
	boolean espbBoolean = false;
	if (espbString.endsWith("*")){
		espbBoolean = true;
		espbString.replace("*", "");
	}
	try{
		espb = Integer.parseInt(espbString);
		if (espbBoolean)
			conjuction.add(Restrictions.like("espb", espb));
		else
			conjuction.add(Restrictions.eq("espb",espb));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./SubjectSearch.jsp");
		dispatcher.forward(req, resp);
		return;	
	}	
}
	
	
	


				

				
				
				
				
				
				
	List<Subject> subjects = SubjectDao.findBySearchCriteria(conjuction);
	
	req.setAttribute("subjects", subjects);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./SubjectSearch.jsp");
	dispatcher.forward(req, resp);
	return;

}
}	