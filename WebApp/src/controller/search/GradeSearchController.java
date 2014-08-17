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

public class GradeSearchController extends HttpServlet {
			
			
@EJB 
IGradeDao GradeDao;
			
			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Conjunction conjuction = Restrictions.conjunction();
				
	

Integer points = null;
if (req.getParameter("points") != null && !"".equals(req.getParameter("points")) ) {
	String pointsString = req.getParameter("points");
	boolean pointsBoolean = false;
	if (pointsString.endsWith("*")){
		pointsBoolean = true;
		pointsString.replace("*", "");
	}
	try{
		points = Integer.parseInt(pointsString);
		if (pointsBoolean)
			conjuction.add(Restrictions.like("points", points));
		else
			conjuction.add(Restrictions.eq("points",points));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeSearch.jsp");
		dispatcher.forward(req, resp);
		return;	
	}	
}
	
	

Integer grade = null;
if (req.getParameter("grade") != null && !"".equals(req.getParameter("grade")) ) {
	String gradeString = req.getParameter("grade");
	boolean gradeBoolean = false;
	if (gradeString.endsWith("*")){
		gradeBoolean = true;
		gradeString.replace("*", "");
	}
	try{
		grade = Integer.parseInt(gradeString);
		if (gradeBoolean)
			conjuction.add(Restrictions.like("grade", grade));
		else
			conjuction.add(Restrictions.eq("grade",grade));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeSearch.jsp");
		dispatcher.forward(req, resp);
		return;	
	}	
}
	
	

String subject = req.getParameter("subject");
	if (subject != null && !subject.equals("")){
		if(subject.endsWith("*")){
			subject = subject.replace("*", "%");
			conjuction.add(Restrictions.like("subject", subject));
		}else{
			conjuction.add(Restrictions.eq("subject", subject));
		}
	}	
	

String professor = req.getParameter("professor");
	if (professor != null && !professor.equals("")){
		if(professor.endsWith("*")){
			professor = professor.replace("*", "%");
			conjuction.add(Restrictions.like("professor", professor));
		}else{
			conjuction.add(Restrictions.eq("professor", professor));
		}
	}	
	

String student = req.getParameter("student");
	if (student != null && !student.equals("")){
		if(student.endsWith("*")){
			student = student.replace("*", "%");
			conjuction.add(Restrictions.like("student", student));
		}else{
			conjuction.add(Restrictions.eq("student", student));
		}
	}	


				

				
				
				
				
				
				
	List<Grade> grades = GradeDao.findBySearchCriteria(conjuction);
	
	req.setAttribute("grades", grades);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeSearch.jsp");
	dispatcher.forward(req, resp);
	return;

}
}	