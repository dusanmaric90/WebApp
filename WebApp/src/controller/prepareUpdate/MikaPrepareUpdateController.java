package controller.prepareUpdate;
		
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		
import model.*;
import dao.*;

		
public class MikaPrepareUpdateController extends HttpServlet {
			
			
@EJB 
IMikaDao MikaDao;
			

	

	
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Integer idMika = null;
			
		if (req.getParameter("id") != null ) {
			idMika = Integer.parseInt(req.getParameter("id"));
		}
		
		Mika tempMika = MikaDao.findById(idMika);
		req.setAttribute("mika", tempMika);
		
		
			
		

		
		getServletContext().getRequestDispatcher("/MikaUpdate.jsp").forward(req, resp);
		
	}
}