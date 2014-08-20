package controller.delete;
		
		import java.io.IOException;
		import javax.ejb.EJB;
		import javax.servlet.ServletException;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		import javax.servlet.RequestDispatcher;
		import model.*;
		import dao.*;
		
		public class StudentDeleteController extends HttpServlet {
			
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
				
				if(idStudent == null){
					getServletContext().getRequestDispatcher("/StudentControllerShow").forward(req, resp);	
				}
					
				try{
	       			Student tempStudent = StudentDao.findById(idStudent);
					StudentDao.delete(tempStudent);
		       	} catch (Exception e){
		       		String error = "Ne moze se obrisati entitet!";
					req.setAttribute("error", error);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/StudentControllerShow");
					//getServletContext().getRequestDispatcher("/StudentControllerShow").forward(req, resp);	
					dispatcher.forward(req, resp);
					return;	
		       	}
				getServletContext().getRequestDispatcher("/StudentControllerShow").forward(req, resp);
				return;
				
			}
		}	