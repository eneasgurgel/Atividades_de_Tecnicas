package br.edu.uni7.tecnicasapp2.repository;

import br.edu.uni7.tecnicasapp2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByCpf(String cpf);

}
