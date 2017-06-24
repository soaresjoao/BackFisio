package com.fisioFinal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.fisioFinal.domain.Usuario;
import com.fisioFinal.util.HibernateUtil;

public class UsuarioDao extends GenericDao<Usuario>{
	@SuppressWarnings("unchecked")
	public Usuario tryLogin(String email,String password) {
		Session sessao = HibernateUtil.getFabricaDeSessoesDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.add(Restrictions.eq("email", email));
			consulta.add(Restrictions.eq("password", password));
			Usuario user = (Usuario) consulta.uniqueResult();
			return user;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	
}
