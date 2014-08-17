package controller.add;
		
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.*;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import javax.servlet.RequestDispatcher;
import java.lang.NumberFormatException;
import java.text.ParseException;
import java.lang.IllegalArgumentException;

import dao.*;

 
    

    
public class GradeControllerAdd extends HttpServlet {
	
@EJB
private IGradeDao GradeDao;
	

	

	


@EJB
private ISubjectDao SubjectDao;	


@EJB
private IProfessorDao ProfessorDao;	


@EJB
private IStudentDao StudentDao;	


	
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



Integer points = null;	


Integer grade = null;	


Integer  subject = null;	
	


Integer  professor = null;	
	


Integer  student = null;	
	






if (req.getParameter("points") != null && !"".equals(req.getParameter("points"))) {
	try{
		points = Integer.parseInt(req.getParameter("points"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	


if (req.getParameter("grade") != null && !"".equals(req.getParameter("grade"))) {
	try{
		grade = Integer.parseInt(req.getParameter("grade"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	


if (req.getParameter("subject") != null && !"".equals(req.getParameter("subject"))) {
	try{
		subject = Integer.parseInt(req.getParameter("subject"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	


if (req.getParameter("professor") != null && !"".equals(req.getParameter("professor"))) {
	try{
		professor = Integer.parseInt(req.getParameter("professor"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	


if (req.getParameter("student") != null && !"".equals(req.getParameter("student"))) {
	try{
		student = Integer.parseInt(req.getParameter("student"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	



				
Grade tempGrade = new Grade();



if(points !=null){
	tempGrade.setPoints(points);
}	


if(grade !=null){
	tempGrade.setGrade(grade);
}	


if(subject !=null){
	tempGrade.setSubject(SubjectDao.findById(subject));
}
	


if(professor !=null){
	tempGrade.setProfessor(ProfessorDao.findById(professor));
}
	


if(student !=null){
	tempGrade.setStudent(StudentDao.findById(student));
}
	



		
try{
	GradeDao.save(tempGrade);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeControllerPrepareAdd");
	dispatcher.forward(req, resp);
	return;
}
	getServletContext().getRequestDispatcher("/GradeControllerShow").forward(req, resp);
	return;

}
}
	
	