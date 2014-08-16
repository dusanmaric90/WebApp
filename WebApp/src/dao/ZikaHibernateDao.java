package dao;
		
		import javax.ejb.Local;
		import javax.ejb.Stateless;
		import dao.generic.AbstractHibernateDao;
		import model.*;
		
		@Stateless
		@Local(IZikaDao.class)
		public class ZikaHibernateDao extends AbstractHibernateDao<Zika> implements 
		IZikaDao{
			
		}