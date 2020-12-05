package com.alelo.crud.cardapio.cardapio.controller;
import com.alelo.crud.cardapio.cardapio.exception.ResourceNotFoundException;
import com.alelo.crud.cardapio.cardapio.model.Produto;
import com.alelo.crud.cardapio.cardapio.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produto")
    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable(value = "id") long produtoId)
    throws ResourceNotFoundException {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(()->
                new ResourceNotFoundException("Nenhum produto encontrado com o id " + produtoId));
        return ResponseEntity.ok().body(produto);

    }

    @PostMapping("/produto")
    public Produto createProduto (@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable (value = "id") Long produtoId, @Valid
                                                    @RequestBody Produto produtoDetails)
            throws ResourceNotFoundException{
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(()->
                new ResourceNotFoundException("Nenhum produto encontrado com o id " + produtoId));
        produto.setCategoria(produtoDetails.getCategoria());
        produto.setNome(produtoDetails.getNome());
        produto.setDescricao(produtoDetails.getDescricao());
        produto.setPreco(produtoDetails.getPreco());

        final Produto atualizaProduto = produtoRepository.save(produto);
        return ResponseEntity.ok (atualizaProduto);
    }

    @DeleteMapping("/produto/{id}")
    public Map<String, Boolean> deleteProduto(@PathVariable(value="id") Long produtoId)
        throws ResourceNotFoundException{
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(()->
                new ResourceNotFoundException("Nenhum produto encontrado com o id " +produtoId));

        produtoRepository.delete(produto);
        Map<String, Boolean> response = new HashMap<>();
        response.put ("deleted", Boolean.TRUE);
        return response;
    }
}
