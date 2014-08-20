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

 
    

    
public class ProfessorControllerAdd extends HttpServlet {
	
@EJB
private IProfessorDao ProfessorDao;
	

	

	


	
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



Integer count_subjests = null;	

	




String firstname = null;	


String lastname = null;	


String  birthday = null;
	


String  gender = null;
	




if (req.getParameter("count_subjests") != null && !"".equals(req.getParameter("count_subjests"))) {
	try{
		count_subjests = Integer.parseInt(req.getParameter("count_subjests"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./ProfessorControllerPrepareAdd");
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

				
Professor tempProfessor = new Professor();



if(count_subjests !=null){
	tempProfessor.setCount_subjests(count_subjests);
}	

	




if(firstname !=null){
	tempProfessor.setFirstname(firstname);
}	


if(lastname !=null){
	tempProfessor.setLastname(lastname);
}	


if(birthday !=null){
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	try{
		Date date = format.parse(birthday);
		tempProfessor.setBirthday(date);
	} catch (ParseException e) {
		String error = "Pogresan format datuma!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./ProfessorControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}
}
	


if(gender !=null){
	Gender enumGender = Gender.valueOf(gender);
	tempProfessor.setGender(enumGender);
}
	

		
try{
	ProfessorDao.save(tempProfessor);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./ProfessorControllerPrepareAdd");
	dispatcher.forward(req, resp);
	return;
}
	getServletContext().getRequestDispatcher("/ProfessorControllerShow").forward(req, resp);
	return;

}
}
	
	