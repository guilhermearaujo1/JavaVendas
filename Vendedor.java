package projetovendas;

import java.io.*;
import java.text.*;

public class Vendedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int cod;
	private String nome, endereco;
	private double comissao;
	private static int idVendedor = 1;

	/**
	 * 
	 * @param cod
	 * @param nome
	 * @param endereco
	 */
	public Vendedor(String nome, String endereco) {	
		this.cod= idVendedor++;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static int getIdVendedor() {
		return idVendedor;
	}

	public static void setIdVendedor(int idVendedor) {
		Vendedor.idVendedor = idVendedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double novaComissao) {
		this.comissao += novaComissao ;
	}
	
	public String toString() {		
		DecimalFormat d = new DecimalFormat("0.00");
		return "\nID do Vendedor: " + cod + "\nNome: " + nome + "\nComissão Acumulada: R$" + d.format(getComissao());
	}	
}