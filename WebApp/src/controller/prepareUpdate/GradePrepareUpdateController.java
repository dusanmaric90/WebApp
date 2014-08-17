package controller.prepareUpdate;
		
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		
import model.*;
import dao.*;

		
public class GradePrepareUpdateController extends HttpServlet {
			
			
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
		Integer idGrade = null;
			
		if (req.getParameter("id") != null ) {
			idGrade = Integer.parseInt(req.getParameter("id"));
		}
		
		Grade tempGrade = GradeDao.findById(idGrade);
		req.setAttribute("grade", tempGrade);
		
		
			
		
			
		
		
		List<Subject> listSubject = SubjectDao.findAll();
		req.setAttribute("listSubject", listSubject);	
		
		
		List<Professor> listProfessor = ProfessorDao.findAll();
		req.setAttribute("listProfessor", listProfessor);	
		
		
		List<Student> listStudent = StudentDao.findAll();
		req.setAttribute("listStudent", listStudent);	
		

		
		getServletContext().getRequestDispatcher("/GradeUpdate.jsp").forward(req, resp);
		
	}
}