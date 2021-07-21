package com.apiexemplo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiexemplo.domains.Aluno;
import com.apiexemplo.domains.Avaliacao;
import com.apiexemplo.repositories.IAlunoRepository;
import com.apiexemplo.repositories.IAvaliacaoRepository;

@Service
public class AlunosService {

	@Autowired
	private IAlunoRepository repAluno;

	@Autowired
	private IAvaliacaoRepository repAvaliacao;

	public List<Aluno> listarAlunos(){
		return repAluno.findAll();
	}

	public Aluno listarAlunoPorUuid(String uuid) {
		return repAluno.findByUuid(uuid);
	}

	public Aluno salvarAluno(Aluno a) {
		a.setUuid( UUIDServices.genUUID() );
		return repAluno.save(a);
	}

	public boolean excluirAluno(String uuid) {
		Aluno a = repAluno.findByUuid(uuid);

		if ( a != null ) {
			repAluno.deleteById(a.getId());
			return true;
		}
		return false;
	}

	public boolean excluirAvaliacao(String uuid, Long idEnd) {
		Aluno a = repAluno.findByUuid(uuid);
		final Avaliacao ava;

		if ( a != null ) {
			ava = repAvaliacao.getById(idEnd);

			if (ava != null && ava.getAluno().getId() == a.getId()) {
				repAvaliacao.deleteById(ava.getId());
				return true;
			}			
		} 
		return false;

	}
}
