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

 
    

    
public class StudentControllerAdd extends HttpServlet {
	
@EJB
private IStudentDao StudentDao;
	

	

	

	


	
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



String indexnumber = null;	


Integer countexampassed = null;	

	




String firstname = null;	


String lastname = null;	


String  birthday = null;
	


String  gender = null;
	




if (req.getParameter("indexnumber") != null && !"".equals(req.getParameter("indexnumber")) ) {
	indexnumber = req.getParameter("indexnumber");
}	


if (req.getParameter("countexampassed") != null && !"".equals(req.getParameter("countexampassed"))) {
	try{
		countexampassed = Integer.parseInt(req.getParameter("countexampassed"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./StudentControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	

	




if (req.getParameter("firstname") != null && !"".equals(req.getParameter("firstname")) ) {
	firstname = req.getParameter("firstname");
}	


if (req.getParameter("lastname") != null && !"".equals(req.getParameter("lastname")) ) {
	lastname = req.getParameter("lastname");
}	


if (req.getParameter("birthday") != null && !"".equals(req.getParameter("birthday")) ) {
	birthday = req.getParameter("birthday");
}	


if (req.getParameter("gender") != null && !"".equals(req.getParameter("gender")) ) {
	gender = req.getParameter("gender");
}	

				
Student tempStudent = new Student();



if(indexnumber !=null){
	tempStudent.setIndexnumber(indexnumber);
}	


if(countexampassed !=null){
	tempStudent.setCountexampassed(countexampassed);
}	

	




if(firstname !=null){
	tempStudent.setFirstname(firstname);
}	


if(lastname !=null){
	tempStudent.setLastname(lastname);
}	


if(birthday !=null){
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	try{
		Date date = format.parse(birthday);
		tempStudent.setBirthday(date);
	} catch (ParseException e) {
		String error = "Pogresan format datuma!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./StudentControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}
}
	


if(gender !=null){
	Gender enumGender = Gender.valueOf(gender);
	tempStudent.setGender(enumGender);
}
	

		
try{
	StudentDao.save(tempStudent);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./StudentControllerPrepareAdd");
	dispatcher.forward(req, resp);
	return;
}
	getServletContext().getRequestDispatcher("/StudentControllerShow").forward(req, resp);
	return;

}
}
	
	