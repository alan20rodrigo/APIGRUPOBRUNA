package com.apiexemplo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiexemplo.domains.Aluno;
import com.apiexemplo.repositories.IAlunoRepository;

@RestController
@RequestMapping("/v1/alunos")
public class AlunosResource {

	@Autowired
	private IAlunoRepository repository;

	@GetMapping
	public ResponseEntity<List<Aluno>> listAlunos() {	
		return ResponseEntity.
				status(HttpStatus.OK).
				body( repository.findAll() );
	}

	@PostMapping()
	public void salvarAluno(@RequestBody Aluno a) {
		repository.save(a);
	}

}
