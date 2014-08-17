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
	    
		
		
		
public class ProfessorUpdateController extends HttpServlet {
			
			
@EJB 
IProfessorDao ProfessorDao;
			

	

	



			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		


Integer countsubjests = null;	

	




String firstname = null;	


String lastname = null;	


String  birthday = null;
	


String  gender = null;
	

				
				
				
String ProfessorId = req.getParameter("id");
				


if (req.getParameter("countsubjests") != null && !"".equals(req.getParameter("countsubjests"))) {
		countsubjests = Integer.parseInt(req.getParameter("countsubjests"));
}
	

	



	
if (req.getParameter("firstname") != null && !"".equals(req.getParameter("firstname")) ) {
	firstname = req.getParameter("firstname");
}

	
if (req.getParameter("lastname") != null && !"".equals(req.getParameter("lastname")) ) {
	lastname = req.getParameter("lastname");
}

	
if (req.getParameter("birthday") != null && !"".equals(req.getParameter("birthday")) ) {
	birthday = req.getParameter("birthday");
}

	
if (req.getParameter("gender") != null && !"".equals(req.getParameter("gender")) ) {
	gender = req.getParameter("gender");
}


				
Professor tempProfessor = new Professor();
tempProfessor.setId(new Integer(ProfessorId));
				


if(countsubjests !=null){
	tempProfessor.setCountsubjests(countsubjests);
}	

	




if(firstname !=null){
	tempProfessor.setFirstname(firstname);
}	


if(lastname !=null){
	tempProfessor.setLastname(lastname);
}	


if(birthday !=null){
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	try{
		Date date = format.parse(birthday);
		tempProfessor.setBirthday(date);
	} catch (ParseException e) {
		String error = "Pogresan format datuma!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./ProfessorAdd.jsp");
		dispatcher.forward(req, resp);
		return;
	}
}
	


if(gender !=null){
	Gender enumGender = Gender.valueOf(gender);
	tempProfessor.setGender(enumGender);
}
	

				
				
try{
	ProfessorDao.merge(tempProfessor);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./ProfessorUpdate.jsp");
	dispatcher.forward(req, resp);
	return;
}
getServletContext().getRequestDispatcher("/ProfessorControllerShow").forward(req, resp);

}
}