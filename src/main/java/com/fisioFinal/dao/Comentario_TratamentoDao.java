package com.fisioFinal.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fisioFinal.domain.Comentario_Tratamento;
import com.fisioFinal.domain.FiltroTratamento;
import com.fisioFinal.domain.Usuario_Tratamento;
import com.fisioFinal.util.HibernateUtil;

public class Comentario_TratamentoDao extends GenericDao<Comentario_Tratamento> {
	@SuppressWarnings("unchecked")
	public List<Comentario_Tratamento> buscaPorTratamento(long tratID) {
		Session sessao = HibernateUtil.getFabricaDeSessoesDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Comentario_Tratamento.class);
			consulta.add(Restrictions.eq("tratID", tratID));			
			List<Comentario_Tratamento> comentarioTrat = consulta.list();
			if(comentarioTrat==null)throw new RuntimeException();
			/*List<String> comentarios = new LinkedList<String>();
			for(int i=0;i<comentarioTrat.size();i++){
				Comentario_Tratamento aux = comentarioTrat.get(i);
				comentarios.add(aux.getUserEmail());
				comentarios.add(aux.getComentario());
			}		
			return comentarios;*/
			return comentarioTrat;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
