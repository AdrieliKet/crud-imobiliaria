package com.imobil.apiimobiliaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.imobil.apiimobiliaria.entity.Terreno;

public interface TerrenoRepository extends JpaRepository<Terreno, Long>{
	
	@Query("select t from Terreno t where t.loteadora.id=?2 and t.situacao=?1") //hql
	List<Terreno> terrenosLoteadoraSituacao(String situacao, Long idLoteadora);
	
	@Query("select t from Terreno t where t.situacao='vendido' and t.loteadora.id=?1")
	List<Terreno> buscarTerrenosVendidosLoteadora(Long idLoteadora);
		
	@Query("select t from Terreno t where t.loteadora.id=?2 and t.situacao='livre") //hql
	List<Terreno> buscarTerrenosLivresLoteadora( Long idLoteadora);
}
