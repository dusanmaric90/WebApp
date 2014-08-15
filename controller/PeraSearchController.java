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

public class PeraSearchController extends HttpServlet {
			
			
@EJB 
IPeraDao PeraDao;
			
			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Conjunction conjuction = Restrictions.conjunction();
				
	

Boja adresa = Boja.valueOf(req.getParameter("adresa"));
conjuction.add(Restrictions.like("adresa", adresa));
	
	

String zika = req.getParameter("zika");
	if (zika != null && !zika.equals("")){
		if(zika.endsWith("*")){
			zika = zika.replace("*", "%");
			conjuction.add(Restrictions.like("zika", zika));
		}else{
			conjuction.add(Restrictions.eq("zika", zika));
		}
	}	


				
	

String ime = req.getParameter("ime");
	if (ime != null && !ime.equals("")){
		if(ime.endsWith("*")){
			ime = ime.replace("*", "%");
			conjuction.add(Restrictions.like("ime", ime));
		}else{
			conjuction.add(Restrictions.eq("ime", ime));
		}
	}	
	

String prezime = req.getParameter("prezime");
	if (prezime != null && !prezime.equals("")){
		if(prezime.endsWith("*")){
			prezime = prezime.replace("*", "%");
			conjuction.add(Restrictions.like("prezime", prezime));
		}else{
			conjuction.add(Restrictions.eq("prezime", prezime));
		}
	}	
	

String mika = req.getParameter("mika");
	if (mika != null && !mika.equals("")){
		if(mika.endsWith("*")){
			mika = mika.replace("*", "%");
			conjuction.add(Restrictions.like("mika", mika));
		}else{
			conjuction.add(Restrictions.eq("mika", mika));
		}
	}	

				
				
				
				
				
				
	ListPera peras = PeraDao.findBySearchCriteria(conjuction);
	
	req.setAttribute("peras", peras);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./PeraSearch.jsp");
	dispatcher.forward(req, resp);
	return;

}
}	