package br.com.desafio.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.desafio.models.Venda;

public class VendaDao {
	
	@PersistenceContext
	private EntityManager manager;

	public void manter(Venda venda) {
		manager.persist(venda);
	}

	public void getId(Venda venda) {

	}

}
