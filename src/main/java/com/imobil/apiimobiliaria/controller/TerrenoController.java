package com.imobil.apiimobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imobil.apiimobiliaria.DTO.TerrenoDTORequest;
import com.imobil.apiimobiliaria.entity.Terreno;
import com.imobil.apiimobiliaria.service.TerrenoService;

@RestController
@RequestMapping("/api/terreno")
public class TerrenoController {
	@Autowired
	private TerrenoService terrenoService;
	
	@PostMapping("/")
	public Terreno salvar(@RequestBody TerrenoDTORequest terrenoDTO) {
		return terrenoService.salvar(terrenoDTO);
	}
	
	//localhost:8080/api/terreno/terrenosLoteadoraSituacao?situacao=livre&idLoteadora=1
	@GetMapping("/terrenosLoteadoraSituacao")
	public List<Terreno> terrenosLoteadoraSituacao(@RequestParam String situacao,@RequestParam Long idLoteadora){
		return terrenoService.terrenosLoteadoraSituacao(situacao, idLoteadora);
	}
	
	@PostMapping("/venderTerreno")
	public Terreno venderTerreno(@RequestBody Terreno terreno) {
		return terrenoService.venderTerreno(terreno.getId(), terreno.getValorVenda());
	}
}
