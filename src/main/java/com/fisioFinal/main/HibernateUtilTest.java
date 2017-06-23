package com.fisioFinal.main;

import org.hibernate.Session;

import com.fisioFinal.util.HibernateUtil;

public class HibernateUtilTest {
	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabricaDeSessoesDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoesDeSessoes().close();
	}
}
