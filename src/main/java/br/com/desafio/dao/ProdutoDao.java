package br.com.desafio.dao;

import java.util.Collections;
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

	/**
	 * 
	 * @param id
	 * @return Produto de acordor com Id informado
	 */
	public Produto getId(int id) {
		return manager.find(Produto.class, id);

	}

	public void remove(Produto produto) {
		manager.remove(produto);
	}

	public List<Produto> listar() {
		return manager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> getDescricao(String descricao) {
		if (descricao == null || "".equals(descricao)) {
			return Collections.EMPTY_LIST;
		}
		return manager.createQuery("From Produto p Where Lower(p.nomeProduto) like lower(:descricao)")
				.setParameter("descricao", "%" + descricao+"%").getResultList();
	}
}
