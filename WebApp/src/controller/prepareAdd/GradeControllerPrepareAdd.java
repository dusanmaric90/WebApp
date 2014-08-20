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
 
public class GradeControllerPrepareAdd extends HttpServlet {
	

	

	


@EJB
private ISubjectDao SubjectDao;	


@EJB
private IProfessorDao ProfessorDao;	


@EJB
private IStudentDao StudentDao;	

		
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		doPost(req,resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {


	

	


List<Subject> listSubject = SubjectDao.findAll();
req.setAttribute("listSubject", listSubject);	


List<Professor> listProfessor = ProfessorDao.findAll();
req.setAttribute("listProfessor", listProfessor);	


List<Student> listStudent = StudentDao.findAll();
req.setAttribute("listStudent", listStudent);	
			

			
getServletContext().getRequestDispatcher("/GradeAdd.jsp").forward(req, resp);
return;
	        
	}
}
	