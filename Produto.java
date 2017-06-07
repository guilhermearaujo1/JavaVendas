package projetovendas;

import java.io.*;
import java.text.*;

public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cod;
	private String descricao;
	private double val;
	private int qtdeItens;
	private static int idProduto = 1;
	private boolean isProdutoPromocao = false;
	private double valPromocao;

	/**
	 * 
	 * @param descricao
	 * @param valor
	 */
	
	public Produto(String descricao, double valor) {
		this.descricao = descricao;
		this.val = valor;
		cod = idProduto++;
	}

	public void setDescricao(String n) {
		descricao = n;
	}

	public void setVal(double val) {
		this.val = val;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public double getVal() {
		return val;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static int getIdProduto() {
		return idProduto;
	}

	public static void setIdProduto(int idProduto) {
		Produto.idProduto = idProduto;
	}	
	
	public boolean getIsProdutoPromocao() {
		return isProdutoPromocao;
	}

	public void setIsProdutoPromocao(boolean isProdutoPromocao) {
		this.isProdutoPromocao = isProdutoPromocao;
	}

	public double getValPromocao() {
		return valPromocao;
	}

	public void setValPromocao(double valPromocao) {
		this.valPromocao = valPromocao;
	}	

	public int getQtdeItens() {
		return qtdeItens;
	}

	public void setQtdeItens(int qtdeItens) {
		this.qtdeItens = qtdeItens;
	}

	public String toString() {
		DecimalFormat d = new DecimalFormat("0.00");
		return "Codigo do Produto: " + cod + "\nDescricao: " + descricao + "\nValor: R$" + d.format(val) + 
				"\nValor na Promocao: " + d.format(getValPromocao());
	}
}