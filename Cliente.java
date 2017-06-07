package projetovendas;


import java.io.*;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cod;
	private String nome;
	private String end;
	private static int idCliente = 1;

	/**
	 * 
	 * @param nome
	 * @param endereco
	 */
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.end = endereco;
		cod = idCliente++;
	}

	public void setNome(String n) {
		nome = n;
	}
	
	public void setCod (int cod){
		this.cod = cod;
	}

	public void setEnd(String e) {
		end = e;
	}
	
	public static void setIdCliente(int idCliente) {
		Cliente.idCliente = idCliente;
	}

	public static int getIdCliente() {
		return idCliente;
	}


	public String getNome() {
		return nome;
	}

	public String getEnd() {
		return end;
	}

	public int getCod() {
		return cod;
	}

	public String toString() {
		return "ID do Cliente: " + cod + "\nNome: " + nome + "\nEndereço: " + end;
	}
}