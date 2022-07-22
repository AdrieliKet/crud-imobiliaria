package com.imobil.apiimobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobil.apiimobiliaria.DTO.TerrenoDTORequest;
import com.imobil.apiimobiliaria.entity.Terreno;
import com.imobil.apiimobiliaria.repository.TerrenoRepository;

@Service
public class TerrenoService {
	@Autowired
	private TerrenoRepository terrenoRepository;
	
	public Terreno salvar(TerrenoDTORequest terrenoDTO) {
		return terrenoRepository.save(new TerrenoDTORequest().toTerreno(terrenoDTO));
	}
	
	public List<Terreno> terrenosLoteadoraSituacao(String situacao, Long idLoteadora){
		return terrenoRepository.terrenosLoteadoraSituacao(situacao, idLoteadora);
	}
	
	public Terreno venderTerreno(Long idTerreno, Double valorVenda) {
		Terreno terreno = terrenoRepository.findById(idTerreno).get();
		terreno.setSituacao("vendido");
		terreno.setValorVenda(valorVenda);
		return terrenoRepository.save(terreno);
	}
}
