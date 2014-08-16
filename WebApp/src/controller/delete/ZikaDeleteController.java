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
		
		public class ZikaDeleteController extends HttpServlet {
			
			@EJB 
			IZikaDao ZikaDao;
			
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
				
				if(idZika == null){
					getServletContext().getRequestDispatcher("/ZikaControllerShow").forward(req, resp);	
				}
					
				try{
	       			Zika tempZika = ZikaDao.findById(idZika);
					ZikaDao.delete(tempZika);
		       	} catch (Exception e){
		       		String error = "Ne moze se obrisati entitet!";
					req.setAttribute("error", error);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/ZikaControllerShow");
					//getServletContext().getRequestDispatcher("/ZikaControllerShow").forward(req, resp);	
					dispatcher.forward(req, resp);
					return;	
		       	}
				getServletContext().getRequestDispatcher("/ZikaControllerShow").forward(req, resp);
				return;
				
			}
		}	