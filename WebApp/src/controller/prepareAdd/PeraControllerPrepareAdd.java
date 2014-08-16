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
 
public class PeraControllerPrepareAdd extends HttpServlet {
	

	


@EJB
private IZikaDao ZikaDao;	


@EJB
private IMikaDao MikaDao;			
		
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		doPost(req,resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {


	


List<Zika> listZika = ZikaDao.findAll();
req.setAttribute("listZika", listZika);	
			

List<Mika> listMika = MikaDao.findAll();
req.setAttribute("listMika", listMika);		

			
getServletContext().getRequestDispatcher("/PeraAdd.jsp").forward(req, resp);
return;
	        
	}
}
	