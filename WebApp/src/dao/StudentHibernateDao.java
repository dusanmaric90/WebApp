package dao;
		
		import javax.ejb.Local;
		import javax.ejb.Stateless;
		import dao.generic.AbstractHibernateDao;
		import model.*;
		
		@Stateless
		@Local(IStudentDao.class)
		public class StudentHibernateDao extends AbstractHibernateDao<Student> implements 
		IStudentDao{
			
		}