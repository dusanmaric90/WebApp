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

		
public class StudentPrepareUpdateController extends HttpServlet {
			
			
@EJB 
IStudentDao StudentDao;
			

	

	

	

	
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Integer idStudent = null;
			
		if (req.getParameter("id") != null ) {
			idStudent = Integer.parseInt(req.getParameter("id"));
		}
		
		Student tempStudent = StudentDao.findById(idStudent);
		req.setAttribute("student", tempStudent);
		
		
			
		
			
		
			
		

		
		getServletContext().getRequestDispatcher("/StudentUpdate.jsp").forward(req, resp);
		
	}
}