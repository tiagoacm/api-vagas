package br.com.l4e.vagas.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.l4e.vagas.dto.CandidatoDTO;
import br.com.l4e.vagas.dto.ErroNegocioDTO;
import br.com.l4e.vagas.exception.CpfCadastradoException;
import br.com.l4e.vagas.form.CandidatoFORM;
import br.com.l4e.vagas.model.Candidato;
import br.com.l4e.vagas.service.CandidatoService;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

	@Autowired
	CandidatoService candidatoService;
	
	@GetMapping
	public ResponseEntity<List<CandidatoDTO>> buscarTodos() throws ServletException {

		try {
			List<Candidato> todosCandidatos = candidatoService.consultar();

			if (todosCandidatos.size() > 0) {
				List<CandidatoDTO> candidatos = CandidatoDTO.converter(todosCandidatos);
				return new ResponseEntity<>(candidatos, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new ServletException("Sistema indisponível, tente mais tarde.");
		}

	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CandidatoDTO> buscarId(@PathVariable int id) throws ServletException {

		try {
			Optional<Candidato> candidato = candidatoService.consultarId(id);

			if (candidato.isPresent()) {
				return new ResponseEntity<>(new CandidatoDTO(candidato.get()), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			throw new ServletException("Sistema indisponível, tente mais tarde.");
		}

	}
	
	@PostMapping
	public ResponseEntity<?> candidatar(@RequestBody @Valid CandidatoFORM form) throws ServletException {

		try {
			Candidato candidato = form.converter();
			candidatoService.incluir(candidato);
			return new ResponseEntity<>(new CandidatoDTO(candidato), HttpStatus.CREATED);
		} catch (CpfCadastradoException e) {
			return new ResponseEntity<>(new ErroNegocioDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new ServletException("Sistema indisponível, tente mais tarde.");
		}
		
	}
}
