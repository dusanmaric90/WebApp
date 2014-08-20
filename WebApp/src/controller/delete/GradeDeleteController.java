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
		
		public class GradeDeleteController extends HttpServlet {
			
			@EJB 
			IGradeDao GradeDao;
			
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				doPost(req,resp);
			}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Integer idGrade = null;
				
				if (req.getParameter("id") != null ) {
					idGrade = Integer.parseInt(req.getParameter("id"));
				}
				
				if(idGrade == null){
					getServletContext().getRequestDispatcher("/GradeControllerShow").forward(req, resp);	
				}
					
				try{
	       			Grade tempGrade = GradeDao.findById(idGrade);
					GradeDao.delete(tempGrade);
		       	} catch (Exception e){
		       		String error = "Ne moze se obrisati entitet!";
					req.setAttribute("error", error);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/GradeControllerShow");
					//getServletContext().getRequestDispatcher("/GradeControllerShow").forward(req, resp);	
					dispatcher.forward(req, resp);
					return;	
		       	}
				getServletContext().getRequestDispatcher("/GradeControllerShow").forward(req, resp);
				return;
				
			}
		}	