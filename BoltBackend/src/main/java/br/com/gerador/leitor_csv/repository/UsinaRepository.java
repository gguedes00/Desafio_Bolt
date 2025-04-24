package br.com.gerador.leitor_csv.repository;

import br.com.gerador.leitor_csv.model.Usina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsinaRepository extends JpaRepository<Usina, Long> {

    @Query(value = "SELECT * FROM usina ORDER BY potencia_ortorgada_km DESC LIMIT 5", nativeQuery = true)
    List<Usina> buscarTop5();

}
