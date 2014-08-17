package dao;
		
		import javax.ejb.Local;
		import javax.ejb.Stateless;
		import dao.generic.AbstractHibernateDao;
		import model.*;
		
		@Stateless
		@Local(IProfessorDao.class)
		public class ProfessorHibernateDao extends AbstractHibernateDao<Professor> implements 
		IProfessorDao{
			
		}