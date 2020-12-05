package com.alelo.crud.cardapio.cardapio.repository;

import com.alelo.crud.cardapio.cardapio.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{


}
