package dao;
		
		import javax.ejb.Local;
		import javax.ejb.Stateless;
		import dao.generic.AbstractHibernateDao;
		import model.*;
		
		@Stateless
		@Local(IPeraDao.class)
		public class PeraHibernateDao extends AbstractHibernateDao<Pera> implements 
		IPeraDao{
			
		}