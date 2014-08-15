package controller.update;
		
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		
import model.*;
import dao.*;

		
public class ZikaPrepareUpdateController extends HttpServlet {
			
			
@EJB 
IZikaDao ZikaDao;
			

	

	


@EJB
private IMikaDao MikaDao;	

	
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Integer idZika = null;
			
		if (req.getParameter("id") != null ) {
			idZika = Integer.parseInt(req.getParameter("id"));
		}
		
		Zika tempZika = ZikaDao.findById(idZika);
		req.setAttribute("zika", tempZika);
		
		
			
		
			
		
		
		List<Mika> listMika = MikaDao.findAll();
		req.setAttribute("listMika", listMika);	
		

		
		getServletContext().getRequestDispatcher("/ZikaUpdate.jsp").forward(req, resp);
		
	}
}