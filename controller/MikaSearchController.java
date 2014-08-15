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

public class MikaSearchController extends HttpServlet {
			
			
@EJB 
IMikaDao MikaDao;
			
			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Conjunction conjuction = Restrictions.conjunction();
				
	

String ime = req.getParameter("ime");
	if (ime != null && !ime.equals("")){
		if(ime.endsWith("*")){
			ime = ime.replace("*", "%");
			conjuction.add(Restrictions.like("ime", ime));
		}else{
			conjuction.add(Restrictions.eq("ime", ime));
		}
	}	


				

				
				
				
				
				
				
	ListMika mikas = MikaDao.findBySearchCriteria(conjuction);
	
	req.setAttribute("mikas", mikas);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./MikaSearch.jsp");
	dispatcher.forward(req, resp);
	return;

}
}	