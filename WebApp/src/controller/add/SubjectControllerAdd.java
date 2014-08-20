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

 
    

    
public class SubjectControllerAdd extends HttpServlet {
	
@EJB
private ISubjectDao SubjectDao;
	

	

	

	


	
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



String subject_name = null;	


Integer espb = null;	

	






if (req.getParameter("subject_name") != null && !"".equals(req.getParameter("subject_name")) ) {
	subject_name = req.getParameter("subject_name");
}	


if (req.getParameter("espb") != null && !"".equals(req.getParameter("espb"))) {
	try{
		espb = Integer.parseInt(req.getParameter("espb"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./SubjectControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	

	



				
Subject tempSubject = new Subject();



if(subject_name !=null){
	tempSubject.setSubject_name(subject_name);
}	


if(espb !=null){
	tempSubject.setEspb(espb);
}	

	



		
try{
	SubjectDao.save(tempSubject);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./SubjectControllerPrepareAdd");
	dispatcher.forward(req, resp);
	return;
}
	getServletContext().getRequestDispatcher("/SubjectControllerShow").forward(req, resp);
	return;

}
}
	
	