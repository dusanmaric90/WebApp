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
		
		public class SubjectDeleteController extends HttpServlet {
			
			@EJB 
			ISubjectDao SubjectDao;
			
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				doPost(req,resp);
			}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Integer idSubject = null;
				
				if (req.getParameter("id") != null ) {
					idSubject = Integer.parseInt(req.getParameter("id"));
				}
				
				if(idSubject == null){
					getServletContext().getRequestDispatcher("/SubjectControllerShow").forward(req, resp);	
				}
					
				try{
	       			Subject tempSubject = SubjectDao.findById(idSubject);
					SubjectDao.delete(tempSubject);
		       	} catch (Exception e){
		       		String error = "Ne moze se obrisati entitet!";
					req.setAttribute("error", error);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/SubjectControllerShow");
					//getServletContext().getRequestDispatcher("/SubjectControllerShow").forward(req, resp);	
					dispatcher.forward(req, resp);
					return;	
		       	}
				getServletContext().getRequestDispatcher("/SubjectControllerShow").forward(req, resp);
				return;
				
			}
		}	