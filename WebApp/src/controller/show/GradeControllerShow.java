package controller.show;
		
		
	import java.io.IOException;
	import java.util.List;
	import javax.ejb.EJB;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import model.*;
	import dao.*;
	public class GradeControllerShow extends HttpServlet {
	
	@EJB
	private IGradeDao GradeDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
     List<Grade> list = GradeDao.findAll();
	
	req.setAttribute("list", list);
    getServletContext().getRequestDispatcher("/"+"Grade"+"Show" + ".jsp").forward(req, resp);
    return;
	}
	
	}