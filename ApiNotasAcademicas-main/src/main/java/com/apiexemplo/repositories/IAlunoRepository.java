package com.apiexemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiexemplo.domains.Aluno;

@Repository
public interface IAlunoRepository extends JpaRepository<Aluno, Long>{

	Aluno getByNome(String nome);

	Aluno getByUuid(String uuid);

	Aluno findByUuid(String uuid);

	void deleteByUuid(String uuid);

}