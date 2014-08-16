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
		
		public class MikaDeleteController extends HttpServlet {
			
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
				
				if(idMika == null){
					getServletContext().getRequestDispatcher("/MikaControllerShow").forward(req, resp);	
				}
					
				try{
	       			Mika tempMika = MikaDao.findById(idMika);
					MikaDao.delete(tempMika);
		       	} catch (Exception e){
		       		String error = "Ne moze se obrisati entitet!";
					req.setAttribute("error", error);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/MikaControllerShow");
					//getServletContext().getRequestDispatcher("/MikaControllerShow").forward(req, resp);	
					dispatcher.forward(req, resp);
					return;	
		       	}
				getServletContext().getRequestDispatcher("/MikaControllerShow").forward(req, resp);
				return;
				
			}
		}	