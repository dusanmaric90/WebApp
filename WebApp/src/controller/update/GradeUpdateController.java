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
	    
		
		
		
public class GradeUpdateController extends HttpServlet {
			
			
@EJB 
IGradeDao GradeDao;
			

	

	


@EJB
private ISubjectDao SubjectDao;	


@EJB
private IProfessorDao ProfessorDao;	


@EJB
private IStudentDao StudentDao;	



			
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
}
			
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		


Integer points = null;	


Integer grade = null;	


Integer  subject = null;	
	


Integer  professor = null;	
	


Integer  student = null;	
	



				
				
				
String GradeId = req.getParameter("id");
				


if (req.getParameter("points") != null && !"".equals(req.getParameter("points"))) {
		points = Integer.parseInt(req.getParameter("points"));
}
	


if (req.getParameter("grade") != null && !"".equals(req.getParameter("grade"))) {
		grade = Integer.parseInt(req.getParameter("grade"));
}
	


if (req.getParameter("subject") != null && !"".equals(req.getParameter("subject"))) {
subject = Integer.parseInt(req.getParameter("subject"));
}
	


if (req.getParameter("professor") != null && !"".equals(req.getParameter("professor"))) {
professor = Integer.parseInt(req.getParameter("professor"));
}
	


if (req.getParameter("student") != null && !"".equals(req.getParameter("student"))) {
student = Integer.parseInt(req.getParameter("student"));
}
	




				
Grade tempGrade = new Grade();
tempGrade.setId(new Integer(GradeId));
				


if(points !=null){
	tempGrade.setPoints(points);
}	


if(grade !=null){
	tempGrade.setGrade(grade);
}	


if(subject !=null){
	tempGrade.setSubject(SubjectDao.findById(subject));
}
	


if(professor !=null){
	tempGrade.setProfessor(ProfessorDao.findById(professor));
}
	


if(student !=null){
	tempGrade.setStudent(StudentDao.findById(student));
}
	



				
				
try{
	GradeDao.merge(tempGrade);
} catch (Exception e){
	String error = "Pogresni podaci!";
	req.setAttribute("error", error);
	RequestDispatcher dispatcher = req.getRequestDispatcher("./GradeUpdate.jsp");
	dispatcher.forward(req, resp);
	return;
}
getServletContext().getRequestDispatcher("/GradeControllerShow").forward(req, resp);

}
}