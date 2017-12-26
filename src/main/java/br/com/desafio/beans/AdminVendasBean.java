package br.com.desafio.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.desafio.dao.ClienteDao;
import br.com.desafio.dao.ProdutoDao;
import br.com.desafio.dao.VendaDao;
import br.com.desafio.models.Cliente;
import br.com.desafio.models.Produto;
import br.com.desafio.models.Venda;

@Named
@ViewScoped
public class AdminVendasBean {
	@Inject
	ClienteDao clienteDao;
	@Inject
	VendaDao vendaDao;
	private Integer qtd = 1;
	private Venda vendas = new Venda();
	private Cliente clienteSelect;
	private Produto produtoSelect;

	private List<Cliente> cli = new ArrayList<>();

	private List<Produto> produtos = new ArrayList();

	@Inject
	private Produto produto;
	@Inject
	private ProdutoDao produtoDao;

	public void addCliente() {

		System.out.println(clienteSelect);
		System.out.println("Aqui!");

	}

	public void realizarVenda() {
		try {
			vendaDao.manter(vendas);
			for (Produto produto : vendas.getProdutos()) {
				Integer quant = produto.getQuantidade();
				produto.setQuantidade(quant - produto.getQtdVenda());
				produtoDao.update(produto);
			}
		} catch (Exception e) {
		}

	}

	public void addProduto() {

		System.out.println("Aqui!!!");
		vendas.getProdutos().add(produtoSelect);
	}

	public List<Cliente> getCli() {
		cli = clienteDao.listar();
		return cli;
	}

	public Venda getVendas() {
		return vendas;
	}

	public void setVendas(Venda vendas) {
		this.vendas = vendas;
	}

	public Cliente getClienteSelect() {
		return clienteSelect;
	}

	public void setClienteSelect(Cliente clienteSelect) {
		this.clienteSelect = clienteSelect;
	}

	public Produto getProdutoSelect() {
		return produtoSelect;
	}

	public void setProdutoSelect(Produto produtoSelect) {
		this.produtoSelect = produtoSelect;
	}

	public List<Produto> getProdutos() {
		produtos = produtoDao.listar();
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@PostConstruct
	public void init() {
		vendas.setDataVenda(new Date());

	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

}
