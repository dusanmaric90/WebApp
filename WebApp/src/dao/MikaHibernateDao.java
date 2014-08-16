package dao;
		
		import javax.ejb.Local;
		import javax.ejb.Stateless;
		import dao.generic.AbstractHibernateDao;
		import model.*;
		
		@Stateless
		@Local(IMikaDao.class)
		public class MikaHibernateDao extends AbstractHibernateDao<Mika> implements 
		IMikaDao{
			
		}