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
		
		public class ProfessorDeleteController extends HttpServlet {
			
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
				
				if(idProfessor == null){
					getServletContext().getRequestDispatcher("/ProfessorControllerShow").forward(req, resp);	
				}
					
				try{
	       			Professor tempProfessor = ProfessorDao.findById(idProfessor);
					ProfessorDao.delete(tempProfessor);
		       	} catch (Exception e){
		       		String error = "Ne moze se obrisati entitet!";
					req.setAttribute("error", error);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/ProfessorControllerShow");
					//getServletContext().getRequestDispatcher("/ProfessorControllerShow").forward(req, resp);	
					dispatcher.forward(req, resp);
					return;	
		       	}
				getServletContext().getRequestDispatcher("/ProfessorControllerShow").forward(req, resp);
				return;
				
			}
		}	