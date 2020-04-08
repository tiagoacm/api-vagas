package br.com.l4e.vagas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.l4e.vagas.model.Vaga;
import br.com.l4e.vagas.repository.VagaRepository;

@Service
public class VagaService {
	
	@Autowired
	VagaRepository vagaRepository;

	public List<Vaga> consultar() {
		return vagaRepository.findAll();
	}

	public Optional<Vaga> consultarId(int id) {
		return vagaRepository.findById(id);
	}

	public Vaga incluir(Vaga vaga) {
		return vagaRepository.save(vaga);
	}

	public Vaga alterar(Vaga vaga) {
		return vagaRepository.save(vaga);
	}

	public void excluir(Integer id) {
		vagaRepository.deleteById(id);
	}

	public List<Vaga> consultarPorCargo(String cargo) {
		return vagaRepository.buscarPorCargo(cargo);
	}

	public Vaga getOne(Integer id) {
		return vagaRepository.getOne(id);
	}

	public Vaga findByCargo(String cargo) {
		// TODO Auto-generated method stub
		return vagaRepository.findByCargo(cargo);
	}
	
	public Vaga findPorId(Integer id) {
		// TODO Auto-generated method stub
		return vagaRepository.findPorId(id);
	}


}
