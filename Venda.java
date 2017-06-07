package projetovendas;

import java.io.*;
import java.text.DecimalFormat;

public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int cod;
	private Produto[] colec;
	private int qtde;
	private Cliente cliente;
	private Vendedor vendedor;
	static float porcentagemComissao = 0.10f;
	static double comissao;
	private static int idVenda = 1;


	/**
	 * 
	 * @param max
	 * @param nome
	 * @param nome
	 */
	public Venda(int max, Cliente cliente, Vendedor vendedor) { // No construtor será solicitado para receber uma quantidade maxima de vendas
		colec = new Produto[max];
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.cod = idVenda++;
		
	}

	public boolean adicProduto(Produto p) {
		if (qtde < colec.length) {
			colec[qtde] = p;
			qtde++;
			return true;
		}
		return false;
	}

	public double getTotalVenda() {
		double tot = 0.0;
		for (int i = 0; i < qtde; i++) {
			if (colec[i].getIsProdutoPromocao()){
				tot += colec[i].getValPromocao();
			}
			else{
				tot += colec[i].getVal();
			}			
		}
		return tot;
	}

	public Produto getProduto(int ind) {
		return colec[ind - 1];
	}
	
	public static double calculaComissao(double totalVenda){
		Venda.comissao = porcentagemComissao * totalVenda;
		return comissao;
	}
	
	public void setQtde(int q) {
		qtde = q;
	}

	public int getQtde() {
		return qtde;
	}

	public static double getComissao() {
		return comissao;
	}

	public static void setComissao(double comissao) {
		Venda.comissao = comissao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static int getIdVenda() {
		return idVenda;
	}

	public static void setIdVenda(int idVenda) {
		Venda.idVenda = idVenda;
	}
	
	public String toStringProdutos (){
		for (Produto i : colec){
			return "Nome do produto: " + i.getDescricao();
		}
		return "Falhou";
	}
	
	public String toString() {
		DecimalFormat d = new DecimalFormat("0.00");
		return "Codigo da venda: " + cod + 
				"\nVendedor: " + vendedor.getNome() +
				"\nCliente: " + cliente.getNome() +
				"\nValor da venda: R$" + d.format(getTotalVenda());
	}
	 
}