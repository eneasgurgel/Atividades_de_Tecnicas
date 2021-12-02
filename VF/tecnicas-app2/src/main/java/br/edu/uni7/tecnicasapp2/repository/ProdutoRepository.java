package br.edu.uni7.tecnicasapp2.repository;

import br.edu.uni7.tecnicasapp2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findAllByCodigoDeBarra(String codigoDeBarra);

    List<Produto> findAllByCategoria(String categoria);

    List<Produto> findAllByQuantidade(Integer quantidade);
}
