package br.com.l4e.vagas.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.l4e.vagas.exception.CpfCadastradoException;
import br.com.l4e.vagas.model.Candidato;
import br.com.l4e.vagas.repository.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	CandidatoRepository candidatoRepository;

	public List<Candidato> consultar() {
		return candidatoRepository.findAll();
	}

	public Optional<Candidato> consultarId(int id) {
		return candidatoRepository.findById(id);
	}

	public Collection<Candidato> consultarPorVaga(int id) {
		return candidatoRepository.findByVagaId(id);
	}

	public Candidato incluir(Candidato candidato) throws CpfCadastradoException {
		String cpf = candidato.getCpf();
		int id = candidato.getVaga().getId();
		
		List<Candidato> candidatoCpf = candidatoRepository.findByCpfVaga(cpf, id);
		
		if (candidatoCpf.isEmpty()) {
			return candidatoRepository.save(candidato);
		} else {
			throw new CpfCadastradoException("CPF já cadastrado para a vaga.");	
		}		
					
	}
	
}
