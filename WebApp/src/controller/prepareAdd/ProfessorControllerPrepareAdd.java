package controller.prepareAdd;
		
		
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import model.*;
 
public class ProfessorControllerPrepareAdd extends HttpServlet {
	

	

	

		
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		doPost(req,resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {


	

	
			

			
getServletContext().getRequestDispatcher("/ProfessorAdd.jsp").forward(req, resp);
return;
	        
	}
}
	