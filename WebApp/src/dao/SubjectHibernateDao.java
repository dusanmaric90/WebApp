package dao;
		
		import javax.ejb.Local;
		import javax.ejb.Stateless;
		import dao.generic.AbstractHibernateDao;
		import model.*;
		
		@Stateless
		@Local(ISubjectDao.class)
		public class SubjectHibernateDao extends AbstractHibernateDao<Subject> implements 
		ISubjectDao{
			
		}