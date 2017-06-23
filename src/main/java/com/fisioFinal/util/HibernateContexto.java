package com.fisioFinal.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.getFabricaDeSessoesDeSessoes().close();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtil.getFabricaDeSessoesDeSessoes();
		
	}

	

}
