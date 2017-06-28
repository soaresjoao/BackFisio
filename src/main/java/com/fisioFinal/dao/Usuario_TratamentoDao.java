package com.fisioFinal.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fisioFinal.domain.FiltroTratamento;
import com.fisioFinal.domain.Usuario_Tratamento;
import com.fisioFinal.util.HibernateUtil;

public class Usuario_TratamentoDao extends GenericDao<Usuario_Tratamento> {
	@SuppressWarnings("unchecked")
	public List<FiltroTratamento> buscaPorEmail(String userEmail) {
		Session sessao = HibernateUtil.getFabricaDeSessoesDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Usuario_Tratamento.class);
			consulta.add(Restrictions.eq("userEmail", userEmail));			
			List<Usuario_Tratamento> userTrat = consulta.list();
			List<FiltroTratamento> tratamentos = new LinkedList<FiltroTratamento>();
			FiltroTratamentoDao fDao = new FiltroTratamentoDao();
			if(userTrat==null)throw new RuntimeException();
			for(int i=0;i<userTrat.size();i++){
				FiltroTratamento aux = fDao.buscarPorAtributo("codigo", userTrat.get(i).getTratID());
				tratamentos.add(aux);
			}			
			return tratamentos;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> buscaCodigosPorEmail(String userEmail) {
		Session sessao = HibernateUtil.getFabricaDeSessoesDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Usuario_Tratamento.class);
			consulta.add(Restrictions.eq("userEmail", userEmail));			
			List<Usuario_Tratamento> userTrat = consulta.list();
			List<Integer> codigos = new LinkedList<Integer>();
			FiltroTratamentoDao fDao = new FiltroTratamentoDao();
			if(userTrat==null)throw new RuntimeException();
			for(int i=0;i<userTrat.size();i++){
				codigos.add((int)userTrat.get(i).getCodigo());
			}			
			return codigos;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	
}
