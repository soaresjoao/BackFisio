package com.fisioFinal.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fisioFinal.domain.FiltroTratamento;
import com.fisioFinal.domain.Usuario;
import com.fisioFinal.util.HibernateUtil;

public class FiltroTratamentoDao extends GenericDao<FiltroTratamento>{
	@SuppressWarnings("unchecked")
	public FiltroTratamento buscaPorCodigo(long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoesDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(FiltroTratamento.class);
			consulta.add(Restrictions.eq("codigo", codigo));			
			FiltroTratamento trat = (FiltroTratamento) consulta.uniqueResult();
			if(trat==null)throw new RuntimeException();
			return trat;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
