package com.apiexemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiexemplo.domains.Avaliacao;

public interface IAvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

}
