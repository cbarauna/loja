package br.com.desafio.beans;

import javax.enterprise.context.RequestScoped;
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

	@Transactional
	public void manter() {
		dao.manter(cliente);
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

}
