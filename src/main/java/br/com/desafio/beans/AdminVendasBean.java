package br.com.desafio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.desafio.dao.ClienteDao;
import br.com.desafio.dao.ProdutoDao;
import br.com.desafio.models.Cliente;
import br.com.desafio.models.Produto;
import br.com.desafio.models.Venda;

@Named
@ViewScoped
public class AdminVendasBean {
	@Inject
	ClienteDao clienteDao;
	private Venda vendas = new Venda();
	private Cliente clienteSelect;
	private List<SelectItem> clientes;
	@Inject
	private Produto produto;
	@Inject
	private ProdutoDao produtoDao;

	public void addCliente() {

		System.out.println(clienteSelect);
	}

	private List<Cliente> cli = new ArrayList<>();

	public void findProdutos(String descricao) {
		// produto = produtoDao.getDescricao(descricao);
	}

	public List<Cliente> getClientes() {
		return clienteDao.listar();
	}

	public List<Cliente> getCli() {
		cli = clienteDao.listar();
		return cli;
	}

	public Cliente getClienteSelect() {
		return clienteSelect;
	}

	public Venda getVendas() {
		return vendas;
	}

	public void setVendas(Venda vendas) {
		this.vendas = vendas;
	}

}
