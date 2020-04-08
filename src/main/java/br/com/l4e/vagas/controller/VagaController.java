package br.com.l4e.vagas.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.transaction.Transactional;
import javax.validation.Valid;

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

import br.com.l4e.vagas.dto.DetalhesVagaDTO;
import br.com.l4e.vagas.dto.VagaDTO;
import br.com.l4e.vagas.form.VagaFORM;
import br.com.l4e.vagas.model.Vaga;
import br.com.l4e.vagas.service.VagaService;


@RestController
@RequestMapping("/vagas")
public class VagaController {
	
	@Autowired
	VagaService vagaService;

	@GetMapping
	public ResponseEntity<List<VagaDTO>> buscarTodos(String cargo) throws ServletException {

		try {
			
			List<Vaga> todasVagas;
					
			if (cargo == null) {
				todasVagas = vagaService.consultar();
			}else {
				todasVagas = vagaService.consultarPorCargo(cargo);
			}
			
			if (todasVagas.size() > 0) {
				List<VagaDTO> vagas = VagaDTO.converter(todasVagas);
				return new ResponseEntity<>(vagas, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new ServletException("Sistema indisponível, tente mais tarde.");
		}

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DetalhesVagaDTO> buscarId(@PathVariable int id) throws ServletException {

		try {
			Optional<Vaga> vagaEncontrada = vagaService.consultarId(id);

			if (vagaEncontrada.isPresent()) {
				return new ResponseEntity<>(new DetalhesVagaDTO(vagaEncontrada.get()), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			throw new ServletException("Sistema indisponível, tente mais tarde.");
		}

	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VagaDTO> incluir(@RequestBody @Valid VagaFORM form) throws ServletException {

		try {
			Vaga vaga = form.converter();
			vagaService.incluir(vaga);	
			return new ResponseEntity<>(new VagaDTO(vaga), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ServletException("Sistema indisponível, tente mais tarde.");
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VagaDTO> alterar(@PathVariable Integer id, @RequestBody @Valid VagaFORM form) throws ServletException {

		try {
			Optional<Vaga> vagaEncontrada = vagaService.consultarId(id);

			if (vagaEncontrada.isPresent()) {
				Vaga vaga = form.atualizar(id, vagaService);
				return new ResponseEntity<>(new VagaDTO(vaga), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			throw new ServletException("Sistema indisponível, tente mais tarde.");
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<VagaDTO> excluir(@PathVariable int id) throws ServletException {

		try {
			Optional<Vaga> vaga = vagaService.consultarId(id);

			if (vaga.isPresent()) {
				vagaService.excluir(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			throw new ServletException("Sistema indisponível, tente mais tarde.");
		}

	}

}
