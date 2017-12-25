package br.com.desafio.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIME)
	private Date dataVenda;
	@ManyToOne
	private Cliente cliente;
	@ManyToMany
	private List<Produto> produtos;
	private Float valorTotal;
	private Float valorRecebido;
	private Float valorTroco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Float getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(Float valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public Float getValorTroco() {
		return valorTroco;
	}

	public void setValorTroco(Float valorTroco) {
		this.valorTroco = valorTroco;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", cliente=" + cliente + ", produtos=" + produtos
				+ ", valorTotal=" + valorTotal + ", valorRecebido=" + valorRecebido + ", valorTroco=" + valorTroco
				+ "]";
	}

}
