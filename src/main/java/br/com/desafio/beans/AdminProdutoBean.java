package br.com.desafio.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.desafio.dao.ProdutoDao;
import br.com.desafio.models.Produto;

@Named
@RequestScoped
public class AdminProdutoBean {

	private Produto produto = new Produto();

	@Inject
	private ProdutoDao dao;

	@Transactional
	public void manter() {
		dao.manter(produto);
	}

	@Produces
	private List<Produto> produtos;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@PostConstruct
	public void init() {
		this.produtos = dao.listar();
	}
}
