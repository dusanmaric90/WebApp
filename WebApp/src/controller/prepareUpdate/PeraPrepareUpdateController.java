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

		
public class PeraPrepareUpdateController extends HttpServlet {
			
			
@EJB 
IPeraDao PeraDao;
			

	


@EJB
private IZikaDao ZikaDao;	

	
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Integer idPera = null;
			
		if (req.getParameter("id") != null ) {
			idPera = Integer.parseInt(req.getParameter("id"));
		}
		
		Pera tempPera = PeraDao.findById(idPera);
		req.setAttribute("pera", tempPera);
		
		
			
		
		
		List<Zika> listZika = ZikaDao.findAll();
		req.setAttribute("listZika", listZika);	
		

		
		getServletContext().getRequestDispatcher("/PeraUpdate.jsp").forward(req, resp);
		
	}
}