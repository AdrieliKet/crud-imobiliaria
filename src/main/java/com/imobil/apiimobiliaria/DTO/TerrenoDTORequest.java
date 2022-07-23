package com.imobil.apiimobiliaria.DTO;

import org.springframework.beans.BeanUtils;

import com.imobil.apiimobiliaria.entity.Loteadora;
import com.imobil.apiimobiliaria.entity.Terreno;

import lombok.Data;

@Data
public class TerrenoDTORequest {
	
	private Long id;
	private String endereco;
	private Double valorPedida;
	private String medidas;
	private String situacao = "livre";
	private Loteadora loteadora;
	
	public Terreno toTerreno(TerrenoDTORequest terrenoDTO) {
		Terreno terreno = new Terreno();
		BeanUtils.copyProperties(terrenoDTO, terreno);
		return terreno;
	}
}
