package com.apiexemplo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiexemplo.domains.Aluno;
import com.apiexemplo.services.AlunosService;

@RestController
@RequestMapping("/v2/alunos")
public class AlunosResource2 {

	@Autowired
	private AlunosService svc;

	@GetMapping
	public ResponseEntity<List<Aluno>> listAllAlunos() {			 
		return ResponseEntity.
				status(HttpStatus.OK).
				body( svc.listarAlunos() );
	}

	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Aluno> buscarPorUuid(@PathVariable String uuid) {	
		return ResponseEntity.
				status(HttpStatus.OK).
				body( svc.listarAlunoPorUuid(uuid) );
	}

	@PostMapping()
	public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno a) {

		return ResponseEntity.
				status(HttpStatus.OK).
				body( this.svc.salvarAluno(a) );
	}

	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirAluno(@PathVariable String uuid) {
		if (svc.excluirAluno(uuid)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping()
	public void atualizarNome() {}

	@DeleteMapping(value = "/{uuid}/avaliacoes/{id}")
	public ResponseEntity<?> excluirAluno(@PathVariable("uuid") String uuid, 
			@PathVariable("id") Long id) {
		svc.excluirAvaliacao(uuid, id);

		return ResponseEntity.noContent().build();
	}
}