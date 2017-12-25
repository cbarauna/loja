package br.com.desafio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.desafio.models.Produto;

public class ProdutoDao {
	@PersistenceContext
	private EntityManager manager;

	public void manter(Produto produto) {
		manager.persist(produto);
	}

	public void getId(Produto produto) {

	}
	
	public List<Produto> listar(){
		return manager.createQuery(
				"SELECT p FROM Produto p", Produto.class)
				.getResultList();
	}
}
