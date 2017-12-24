package br.com.desafio.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.desafio.models.Cliente;

public class ClienteDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void manter(Cliente cliente) {
		manager.persist(cliente);
	}
	
	public void getId(Cliente cliente) {
	
	}
}
