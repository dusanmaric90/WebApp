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
 
    

    
public class PeraControllerAdd extends HttpServlet {
	
@EJB
private IPeraDao PeraDao;
	

	


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



String  adresa = null;
	


Integer  zika = null;	
	




String ime = null;	


String prezime = null;	


Integer  mika = null;	
	




if (req.getParameter("adresa") != null && !"".equals(req.getParameter("adresa")) ) {
	adresa = req.getParameter("adresa");
}	


if (req.getParameter("zika") != null && !"".equals(req.getParameter("zika"))) {
	try{
		zika = Integer.parseInt(req.getParameter("zika"));
	} catch (NumberFormatException e) {
		String error = "Polje treba da bude broj!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./PeraControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	




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
		RequestDispatcher dispatcher = req.getRequestDispatcher("./PeraControllerPrepareAdd");
		dispatcher.forward(req, resp);
		return;	
	}

}
	

				
Pera tempPera = new Pera();



if(adresa !=null){
	Boja enumAdresa = Boja.valueOf(adresa);
	tempPera.setAdresa(enumAdresa);
}
	


if(zika !=null){
	tempPera.setZika(ZikaDao.findById(zika));
}
	




if(ime !=null){
	tempPera.setIme(ime);
}	


if(prezime !=null){
	tempPera.setPrezime(prezime);
}	


if(mika !=null){
	tempPera.setMika(MikaDao.findById(mika));
}
	

		
try{
	PeraDao.save(tempPera);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./PeraControllerPrepareAdd");
	dispatcher.forward(req, resp);
	return;
}
	getServletContext().getRequestDispatcher("/PeraControllerShow").forward(req, resp);
	return;

}
}
	
	