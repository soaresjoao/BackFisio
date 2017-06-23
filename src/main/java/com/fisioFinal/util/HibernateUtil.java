package com.fisioFinal.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();
	
	public static SessionFactory getFabricaDeSessoesDeSessoes(){
		return fabricaDeSessoes;
	}
	
	private static SessionFactory criarFabricaDeSessoes(){
		try {
			Configuration configuracao = new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			SessionFactory fabrica = configuracao.buildSessionFactory();
			
			return fabrica;
		} catch (Exception e) {
			System.out.println("A fabrica de sessões não pode ser criada. " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
}

