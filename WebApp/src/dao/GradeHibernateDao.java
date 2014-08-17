package dao;
		
		import javax.ejb.Local;
		import javax.ejb.Stateless;
		import dao.generic.AbstractHibernateDao;
		import model.*;
		
		@Stateless
		@Local(IGradeDao.class)
		public class GradeHibernateDao extends AbstractHibernateDao<Grade> implements 
		IGradeDao{
			
		}