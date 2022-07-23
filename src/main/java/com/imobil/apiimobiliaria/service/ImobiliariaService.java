package com.imobil.apiimobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobil.apiimobiliaria.entity.Loteadora;
import com.imobil.apiimobiliaria.entity.Terreno;
import com.imobil.apiimobiliaria.repository.LoteadoraRepository;
import com.imobil.apiimobiliaria.repository.TerrenoRepository;

@Service
public class ImobiliariaService {
	@Autowired
	private TerrenoRepository terrenoRepository;
	
	@Autowired
	private LoteadoraRepository loteadoraRepository;
	
	public Double valorComissaoLoteadora(Long idLoteadora) {
		Loteadora loteadora = loteadoraRepository.findById(idLoteadora).get();
		List<Terreno> terrenosVendidos = terrenoRepository.buscarTerrenosVendidosLoteadora(idLoteadora);
		Double totalvendido= 0.;
		Double comissao = 0.;
		for(Terreno t:terrenosVendidos) {
			totalvendido+=t.getValorVenda();
		}
		comissao = totalvendido*(loteadora.getPorcentagemComissao()/100);
		return comissao;
	}
}
