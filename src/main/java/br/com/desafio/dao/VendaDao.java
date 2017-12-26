package br.com.desafio.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.desafio.models.Venda;

@Transactional(value = TxType.REQUIRED)
public class VendaDao {

	@PersistenceContext
	private EntityManager manager;

	public void manter(Venda venda) {
		manager.persist(venda);
	}

	public void getId(Venda venda) {

	}

}
