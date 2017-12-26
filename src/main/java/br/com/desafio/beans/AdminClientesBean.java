package br.com.desafio.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.desafio.dao.ClienteDao;
import br.com.desafio.models.Cliente;

@Named
@RequestScoped
public class AdminClientesBean {

	private Cliente cliente = new Cliente();
	@Inject
	private ClienteDao dao;
	@Produces
	private List<Cliente> clientes;

	@Transactional
	public void manter() {
		dao.manter(cliente);
	}

	/**
	 * Remover o produto	
	 */
	@Transactional
	public void remover(Cliente cliente) {
		dao.remove(dao.getId(cliente.getId()));
	}
	public void listar() {
		System.out.println();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@PostConstruct
	public void init() {
		this.clientes = dao.listar();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
