package com.fisioFinal.util;

import org.hibernate.Session;
import org.junit.Test;


public class HibernateTest {
	@Test
	public void conectar(){
		Session sessao = HibernateUtil.getFabricaDeSessoesDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoesDeSessoes().close();
	}
}
