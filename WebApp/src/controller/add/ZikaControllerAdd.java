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
import enumeration.*;
 
    

    
public class ZikaControllerAdd extends HttpServlet {
	
@EJB
private IZikaDao ZikaDao;
	

	

	


@EJB
private IMikaDao MikaDao;	


	
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



String ime = null;	


String prezime = null;	


Integer  mika = null;	
	






if (req.getParameter("ime") != null && !"".equals(req.getParameter("ime")) ) {
	ime = req.getParameter("ime");
}	


if (req.getParameter("prezime") != null && !"".equals(req.getParameter("prezime")) ) {
	prezime = req.getParameter("prezime");
}	


if (req.getParameter("mika") != null && !"".equals(req.getParameter("mika"))) {
	try{
		mika = Integer.parseInt(req.getParameter("mika"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./ZikaControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	



				
Zika tempZika = new Zika();



if(ime !=null){
	tempZika.setIme(ime);
}	


if(prezime !=null){
	tempZika.setPrezime(prezime);
}	


if(mika !=null){
	tempZika.setMika(MikaDao.findById(mika));
}
	



		
try{
	ZikaDao.save(tempZika);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./ZikaControllerPrepareAdd");
	dispatcher.forward(req, resp);
	return;
}
	getServletContext().getRequestDispatcher("/ZikaControllerShow").forward(req, resp);
	return;

}
}
	
	