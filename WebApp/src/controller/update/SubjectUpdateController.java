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
	    
		
		
		
public class SubjectUpdateController extends HttpServlet {
			
			
@EJB 
ISubjectDao SubjectDao;
			

	

	

	



			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		


String subject_name = null;	


Integer espb = null;	

	



				
				
				
String SubjectId = req.getParameter("id");
				


if (req.getParameter("subject_name") != null && !"".equals(req.getParameter("subject_name")) ) {
	subject_name = req.getParameter("subject_name");
}	


if (req.getParameter("espb") != null && !"".equals(req.getParameter("espb"))) {
		espb = Integer.parseInt(req.getParameter("espb"));
}
	

	




				
Subject tempSubject = new Subject();
tempSubject.setId(new Integer(SubjectId));
				


if(subject_name !=null){
	tempSubject.setSubject_name(subject_name);
}	


if(espb !=null){
	tempSubject.setEspb(espb);
}	

	



				
				
try{
	SubjectDao.merge(tempSubject);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./SubjectUpdate.jsp");
	dispatcher.forward(req, resp);
	return;
}
getServletContext().getRequestDispatcher("/SubjectControllerShow").forward(req, resp);

}
}