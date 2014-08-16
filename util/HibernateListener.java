package util;

		import javax.servlet.ServletContextEvent;
		import javax.servlet.ServletContextListener;
		
		public class HibernateListener implements ServletContextListener {
		
			@Override
			public void contextDestroyed(ServletContextEvent arg0) {
				HibernateUtil.getSessionfactory().close();
			}
		
			@Override
			public void contextInitialized(ServletContextEvent arg0) {
				try {
					HibernateUtil.getSessionfactory();
				} catch (Exception e) {
					e.printStackTrace();
				}
		
			}
		
		}