package com.alelo.crud.cardapio.cardapio;

import com.alelo.crud.cardapio.cardapio.model.Produto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CardapioApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetCategoria(){
		Produto produto = new Produto();
		produto.setCategoria("Lanches");
		Assert.assertEquals("Lanches",produto.getCategoria());
	}

	@Test
	public void testGetNome(){
		Produto produto = new Produto();
		produto.setNome("Pãozinho");
		Assert.assertEquals("Pãozinho",produto.getNome());
	}

	@Test
	public void testGetDescricao(){
		Produto produto = new Produto();
		produto.setDescricao("Incrível pão de batata");
		Assert.assertEquals("Incrível pão de batata",produto.getDescricao());
	}

	@Test
	public void testGetPreco(){
		Produto produto = new Produto();
		produto.setPreco(5.0);
		Assert.assertEquals(5.0,produto.getPreco(),0);
	}

}
