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
	    
		
		
		
public class StudentUpdateController extends HttpServlet {
			
			
@EJB 
IStudentDao StudentDao;
			

	

	

	



			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		


String indexnumber = null;	


Integer countexampassed = null;	

	




String firstname = null;	


String lastname = null;	


String  birthday = null;
	


String  gender = null;
	

				
				
				
String StudentId = req.getParameter("id");
				


if (req.getParameter("indexnumber") != null && !"".equals(req.getParameter("indexnumber")) ) {
	indexnumber = req.getParameter("indexnumber");
}	


if (req.getParameter("countexampassed") != null && !"".equals(req.getParameter("countexampassed"))) {
		countexampassed = Integer.parseInt(req.getParameter("countexampassed"));
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


				
Student tempStudent = new Student();
tempStudent.setId(new Integer(StudentId));
				


if(indexnumber !=null){
	tempStudent.setIndexnumber(indexnumber);
}	


if(countexampassed !=null){
	tempStudent.setCountexampassed(countexampassed);
}	

	




if(firstname !=null){
	tempStudent.setFirstname(firstname);
}	


if(lastname !=null){
	tempStudent.setLastname(lastname);
}	


if(birthday !=null){
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	try{
		Date date = format.parse(birthday);
		tempStudent.setBirthday(date);
	} catch (ParseException e) {
		String error = "Pogresan format datuma!";
		req.setAttribute("error", error);
		RequestDispatcher dispatcher = req.getRequestDispatcher("./StudentAdd.jsp");
		dispatcher.forward(req, resp);
		return;
	}
}
	


if(gender !=null){
	Gender enumGender = Gender.valueOf(gender);
	tempStudent.setGender(enumGender);
}
	

				
				
try{
	StudentDao.merge(tempStudent);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./StudentUpdate.jsp");
	dispatcher.forward(req, resp);
	return;
}
getServletContext().getRequestDispatcher("/StudentControllerShow").forward(req, resp);

}
}