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
 
    

    
public class MikaControllerAdd extends HttpServlet {
	
@EJB
private IMikaDao MikaDao;
	

	


	
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



String ime = null	






if (req.getParameter("ime") != null && !"".equals(req.getParameter("ime")) ) {
	ime = req.getParameter("ime");
}	



				
Mika tempMika = new Mika();



if(ime !=null){
	tempMika.setIme(ime);
}	



		
try{
	MikaDao.save(tempMika);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./MikaControllerPrepareAdd");
	dispatcher.forward(req, resp);
	return;
}
	getServletContext().getRequestDispatcher("/MikaControllerShow").forward(req, resp);
	return;

}
}
	
	