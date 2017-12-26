package br.com.desafio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.desafio.models.Cliente;

@Transactional(value = TxType.REQUIRED)
public class ClienteDao {

	@PersistenceContext
	private EntityManager manager;

	public void manter(Cliente cliente) {
		manager.persist(cliente);
	}

	public Cliente getId(int id) {
		return manager.find(Cliente.class, id);

	}

	public void remove(Cliente cliente) {
		manager.remove(cliente);
	}

	public List<Cliente> listar() {
		return manager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
	}
}
