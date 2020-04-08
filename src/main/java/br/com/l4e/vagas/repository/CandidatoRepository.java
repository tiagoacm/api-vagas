package br.com.l4e.vagas.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.l4e.vagas.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato,Integer>  {

	public Optional<Candidato> findById(int id);

	public Collection<Candidato> findByVagaId(int id);

	public List<Candidato> findByCpf(String cpf);

	@Query(value = "select * from candidato where cpf = ?1 and vaga_id = ?2", nativeQuery = true)
	public List<Candidato> findByCpfVaga(String cpf, Integer id);
	
	
	
	
}
