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
	    import enumeration.*;
		
		
		
		public class ZikaUpdateController extends HttpServlet {
			
			
@EJB 
IZikaDao ZikaDao;
			

	

	


@EJB
private IMikaDao MikaDao;	



			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		


String ime = null;	


String prezime = null;	


Integer  mika = null;	
	



				
				
				
String ZikaId = req.getParameter("id");
				


if (req.getParameter("ime") != null && !"".equals(req.getParameter("ime")) ) {
	ime = req.getParameter("ime");
}	


if (req.getParameter("prezime") != null && !"".equals(req.getParameter("prezime")) ) {
	prezime = req.getParameter("prezime");
}	


if (req.getParameter("mika") != null && !"".equals(req.getParameter("mika"))) {
mika = Integer.parseInt(req.getParameter("mika"));
}
	




				
Zika tempZika = new Zika();
tempZika.setId(new Integer(ZikaId));
				


if(ime !=null){
	tempZika.setIme(ime);
}	


if(prezime !=null){
	tempZika.setPrezime(prezime);
}	


if(mika !=null){
	tempZika.setMika(MikaDao.findById(mika));
}
	



				
				
try{
	ZikaDao.merge(tempZika);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./ZikaUpdate.jsp");
	dispatcher.forward(req, resp);
	return;
}
getServletContext().getRequestDispatcher("/ZikaControllerShow").forward(req, resp);

}
}