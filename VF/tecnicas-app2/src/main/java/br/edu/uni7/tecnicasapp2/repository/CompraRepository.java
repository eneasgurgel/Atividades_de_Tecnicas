package br.edu.uni7.tecnicasapp2.repository;

import br.edu.uni7.tecnicasapp2.model.Compra;
import br.edu.uni7.tecnicasapp2.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends MongoRepository<Compra, Integer> {

    List<Compra> findAllByCpfCliente(String cpfCliente);

    Compra findByNotaFiscal(NotaFiscal notaFiscal);
}
