package br.com.l4e.vagas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.l4e.vagas.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga,Integer> {

	public Optional<Vaga> findById(int id);
	
	@Query("select v from Vaga v where v.cargo like CONCAT('%',:cargo ,'%')") 
	List<Vaga> buscarPorCargo(@Param("cargo") String cargo);

	public Vaga findByCargo(String cargo);
	
	@Query("select v from Vaga v where v.id = :id")
	public Vaga findPorId(@Param("id") Integer id);
}
