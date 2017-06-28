package com.fisio.dao;

import org.junit.Test;

import com.fisioFinal.dao.FiltroTratamentoDao;
import com.fisioFinal.domain.FiltroTratamento;

public class FiltroTratamentoDaoTest {
	
	@Test
	public void salvar(){
		FiltroTratamento tratamento = new FiltroTratamento();
		tratamento.setAnoPublicacao("2013");
		tratamento.setDiagnostigo("patellofemoral pain");
		tratamento.setLink("http://www.jospt.org/doi/10.2519/jospt.2007.2433?code=jospt-site");
		tratamento.setQuantCurtidas(3);
		tratamento.setReferencia("Ref. to jospt");
		tratamento.setRelevance(0);
		tratamento.setResumo("Randomized controlled trial, pretest-posttest design.");
		tratamento.setTempoLesao("Aguda");
		tratamento.setTotalUsos(4);
		
		FiltroTratamentoDao filtroDao = new FiltroTratamentoDao();
		filtroDao.salvar(tratamento);
	}
}
