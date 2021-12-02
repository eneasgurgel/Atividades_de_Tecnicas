package br.edu.uni7.tecnicasapp2.service;

import br.edu.uni7.tecnicasapp2.exception.ClienteDesconhecido;
import br.edu.uni7.tecnicasapp2.exception.EstoqueInsuficienteException;
import br.edu.uni7.tecnicasapp2.model.Cliente;
import br.edu.uni7.tecnicasapp2.model.Compra;
import br.edu.uni7.tecnicasapp2.model.Produto;
import br.edu.uni7.tecnicasapp2.repository.ClienteRepository;
import br.edu.uni7.tecnicasapp2.repository.CompraRepository;
import br.edu.uni7.tecnicasapp2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public  CompraService(CompraRepository compraRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository){
        this.compraRepository = compraRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Compra> list() {
        return compraRepository.findAll();
    }

    public Compra findById(Integer id) {
        return compraRepository.findById(id).get();
    }

    public Compra create(Compra compra) {
        double valorTotal = 0;
        Cliente clienteBD = clienteRepository.findByCpf(compra.getCpfCliente());
        if (clienteBD == null){
            throw new ClienteDesconhecido();
        }
        List<Produto> produtos = compra.getProdutos();
        if (produtos != null) {
            for (Produto produto : produtos){
                Produto produtoDB = produtoRepository.findById(produto.getId()).get();
                if  (produtoDB.getQuantidade() < produto.getQuantidade()){
                    throw new EstoqueInsuficienteException();
                }else{
                    valorTotal = valorTotal + (produtoDB.getPreco() * produto.getQuantidade());
                    produtoDB.setQuantidade(produtoDB.getQuantidade() - produto.getQuantidade());
                }
            }
        }
        compra.setValor(valorTotal);
        clienteBD.setGastoTotal(clienteBD.getGastoTotal() + valorTotal);
        return compraRepository.save(compra);

    }

    public Compra update(Compra compra) {
        compraRepository.save(compra);
        return compra;
    }

    public void remove(Integer id) {
        compraRepository.deleteById(id);
    }

    public List<Compra> findAllByCpfCliente(String cpfCliente){
        return compraRepository.findAllByCpfCliente(cpfCliente);
    }
}
