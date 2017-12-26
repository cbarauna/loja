package br.com.desafio.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

	
	public void manter() {
		try {
			dao.manter(cliente);
			init();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cadastro Realizado", "Produto Cadastrado com Sucesso!"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Remover o produto
	 */
	@Transactional
	public void remover(Cliente cliente) {
		dao.remove(dao.getId(cliente.getId()));
		listar();
	}

	public void listar() {
		this.clientes = dao.listar();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@PostConstruct
	public void init() {

		listar();
		setCliente(new Cliente());
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;

	}

}
