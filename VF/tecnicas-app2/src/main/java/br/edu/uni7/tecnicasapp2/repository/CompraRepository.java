package br.edu.uni7.tecnicasapp2.repository;

import br.edu.uni7.tecnicasapp2.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

    List<Compra> findAllByCpfCliente(String cpfCliente);
}
