package controller.update;
		
		import java.text.SimpleDateFormat;	
		import java.text.ParseException;
		import java.io.IOException;
		import javax.servlet.RequestDispatcher;
		import javax.ejb.EJB;
		import javax.servlet.ServletException;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		import model.*;
		import java.util.Date;
		import dao.*;
	
		
		
		
		public class MikaUpdateController extends HttpServlet {
			
			
@EJB 
IMikaDao MikaDao;
			

	



			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		


String ime = null	



				
				
				
String MikaId = req.getParameter("id");
				


if (req.getParameter("ime") != null && !"".equals(req.getParameter("ime")) ) {
	ime = req.getParameter("ime");
}	




				
Mika tempMika = new Mika();
tempMika.setId(new Integer(MikaId));
				


if(ime !=null){
	tempMika.setIme(ime);
}	



				
				
try{
	MikaDao.merge(tempMika);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./MikaUpdate.jsp");
	dispatcher.forward(req, resp);
	return;
}
getServletContext().getRequestDispatcher("/MikaControllerShow").forward(req, resp);

}
}