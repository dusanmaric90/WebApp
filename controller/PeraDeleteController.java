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
		
		public class PeraDeleteController extends HttpServlet {
			
			@EJB 
			IPeraDao PeraDao;
			
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
				
				if(idPera == null){
					getServletContext().getRequestDispatcher("/PeraControllerShow").forward(req, resp);	
				}
					
				try{
	       			Pera tempPera = PeraDao.findById(idPera);
					PeraDao.delete(tempPera);
		       	} catch (Exception e){
		       		String error = "Ne moze se obrisati entitet!";
					req.setAttribute("error", error);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/PeraControllerShow");
					//getServletContext().getRequestDispatcher("/PeraControllerShow").forward(req, resp);	
					dispatcher.forward(req, resp);
					return;	
		       	}
				getServletContext().getRequestDispatcher("/PeraControllerShow").forward(req, resp);
				return;
				
			}
		}	