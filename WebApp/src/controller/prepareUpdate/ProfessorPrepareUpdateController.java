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

		
public class ProfessorPrepareUpdateController extends HttpServlet {
			
			
@EJB 
IProfessorDao ProfessorDao;
			

	

	

	
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Integer idProfessor = null;
			
		if (req.getParameter("id") != null ) {
			idProfessor = Integer.parseInt(req.getParameter("id"));
		}
		
		Professor tempProfessor = ProfessorDao.findById(idProfessor);
		req.setAttribute("professor", tempProfessor);
		
		
			
		
			
		

		
		getServletContext().getRequestDispatcher("/ProfessorUpdate.jsp").forward(req, resp);
		
	}
}