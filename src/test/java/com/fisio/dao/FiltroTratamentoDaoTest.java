package com.fisio.dao;

import org.junit.Test;

import com.fisioFinal.dao.FiltroTratamentoDao;
import com.fisioFinal.domain.FiltroTratamento;

public class FiltroTratamentoDaoTest {
	
	@Test
	public void salvar(){
		FiltroTratamento tratamento = new FiltroTratamento();
		tratamento.setAnoPublicacao("2011");
		tratamento.setDiagnostigo("Condromalacia Patelar");
		tratamento.setLink("www.testa.com");
		tratamento.setReferencia("Referencia teste");
		tratamento.setResumo("Resumindo");
		tratamento.setTempoLesao("Aguda");
		
		FiltroTratamentoDao filtroDao = new FiltroTratamentoDao();
		filtroDao.salvar(tratamento);
	}
}
