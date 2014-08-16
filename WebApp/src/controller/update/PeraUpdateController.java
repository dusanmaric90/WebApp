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
		
		
		
		public class PeraUpdateController extends HttpServlet {
			
			
@EJB 
IPeraDao PeraDao;
			

	


@EJB
private IZikaDao ZikaDao;	



@EJB
private IMikaDao MikaDao;			

			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		


String  adresa = null;
	


Integer  zika = null;	
	




String ime = null;	


String prezime = null;	


Integer  mika = null;	
	

				
				
				
String PeraId = req.getParameter("id");
				


if (req.getParameter("adresa") != null && !"".equals(req.getParameter("adresa")) ) {
	adresa = req.getParameter("adresa");
}	


if (req.getParameter("zika") != null && !"".equals(req.getParameter("zika"))) {
zika = Integer.parseInt(req.getParameter("zika"));
}
	




if (req.getParameter("ime") != null && !"".equals(req.getParameter("ime")) ) {
	ime = req.getParameter("ime");
}	


if (req.getParameter("prezime") != null && !"".equals(req.getParameter("prezime")) ) {
	prezime = req.getParameter("prezime");
}	


if (req.getParameter("mika") != null && !"".equals(req.getParameter("mika"))) {
		mika = Integer.parseInt(req.getParameter("mika"));
}
	


				
Pera tempPera = new Pera();
tempPera.setId(new Integer(PeraId));
				


if(adresa !=null){
	Boja enumAdresa = Boja.valueOf(adresa);
	tempPera.setAdresa(enumAdresa);
}
	


if(zika !=null){
	tempPera.setZika(ZikaDao.findById(zika));
}
	




if(ime !=null){
	tempPera.setIme(ime);
}	


if(prezime !=null){
	tempPera.setPrezime(prezime);
}	


if(mika !=null){
	tempPera.setMika(MikaDao.findById(mika));
}
	

				
				
try{
	PeraDao.merge(tempPera);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./PeraUpdate.jsp");
	dispatcher.forward(req, resp);
	return;
}
getServletContext().getRequestDispatcher("/PeraControllerShow").forward(req, resp);

}
}