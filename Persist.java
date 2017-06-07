package projetovendas;

import java.io.*;

public class Persist {

	//private static int idCliente;
	private String prefixoCliente = "CL - ";
	private String prefixoVendedor = "VD - ";
	private String prefixoProduto = "PD - ";
	private String prefixoVenda = "V - ";
	private String ultimoClienteCadastrado = "ultimoClienteCadastrado";
	private String ultimoVendedorCadastrado = "ultimoVendedorCadastrado";
	private String ultimoProdutoCadastrado = "ultimoProdutoCadastrado";
	private String ultimaVendaCadastrada = "ultimaVendaCadastrada";
	//private Cliente cliente;

	/**
	 * 
	 * @param serializable
	 * @param nomeCliente
	 */
	public void salvarCliente(Serializable serializable, String nomeCliente) {
		try {
			FileOutputStream fos = new FileOutputStream(prefixoCliente + nomeCliente);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			atualizarUltimoCliente(serializable);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}
	}

	public void atualizarUltimoCliente(Serializable serializable) {

		try {
			FileOutputStream fos = new FileOutputStream(ultimoClienteCadastrado);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}
	}

	/**
	 * 
	 * @param nomeCliente
	 * @return Cliente
	 */
	public Object lerCliente(String nomeCliente) {
		try {
			FileInputStream fis = new FileInputStream(prefixoCliente + nomeCliente);
			ObjectInputStream oos = new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado em nossa base!");
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @return Cliente
	 */
	public Object lerUltimoClienteCadastrado() {
		try {
			FileInputStream fis = new FileInputStream(ultimoClienteCadastrado);
			ObjectInputStream oos = new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado em nossa base!");
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param serializable
	 * @param nomeVendedor
	 */
	public void salvarVendedor(Serializable serializable, String nomeVendedor) {
		try {
			FileOutputStream fos = new FileOutputStream(prefixoVendedor + nomeVendedor);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			atualizarUltimoVendedor(serializable);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}
	}

	/**
	 * 
	 * @param serializable
	 */
	public void atualizarUltimoVendedor(Serializable serializable) {

		try {
			FileOutputStream fos = new FileOutputStream(ultimoVendedorCadastrado);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}
	}

	/**
	 * 
	 * @param nomeVendedor
	 * @return Vendedor
	 */
	public Object lerVendedor(String nomeVendedor) {
		try {
			FileInputStream fis = new FileInputStream(prefixoVendedor + nomeVendedor);
			ObjectInputStream oos = new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado em nossa base!");
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		
		return null;
	}
	
	public Object lerUltimoVendedorCadastrado() {
		try {
			FileInputStream fis = new FileInputStream(ultimoVendedorCadastrado);
			ObjectInputStream oos = new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado em nossa base!");
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param serializable
	 * @param nomeProduto
	 */
	public void salvarProduto(Serializable serializable, String nomeProduto) {
		try {
			FileOutputStream fos = new FileOutputStream(prefixoProduto + nomeProduto);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			atualizarUltimoProduto(serializable);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}
	}

	/**
	 * 
	 * @param serializable
	 */
	public void atualizarUltimoProduto(Serializable serializable) {

		try {
			FileOutputStream fos = new FileOutputStream(ultimoProdutoCadastrado);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}
	}

	/**
	 * 
	 * @param nomeProduto
	 * @return Produto
	 */
	public Object lerProduto(String nomeProduto) {
		try {
			FileInputStream fis = new FileInputStream(prefixoProduto + nomeProduto);
			ObjectInputStream oos = new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado em nossa base!");
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

		return null;
	}

	public Object lerUltimoProdutoCadastrado() {
		try {
			FileInputStream fis = new FileInputStream(ultimoProdutoCadastrado);
			ObjectInputStream oos = new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado em nossa base!");
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

		return null;
	}

	public void salvarVenda(Serializable serializable, String codVenda) {
		try {
			FileOutputStream fos = new FileOutputStream(prefixoVenda + codVenda);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			atualizarUltimaVenda(serializable);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}
	}

	public void atualizarUltimaVenda(Serializable serializable) {

		try {
			FileOutputStream fos = new FileOutputStream(ultimaVendaCadastrada);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}
	}

	public Object lerVenda(String codVenda) {
		try {
			FileInputStream fis = new FileInputStream(prefixoVenda + codVenda);
			ObjectInputStream oos = new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado em nossa base!");
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

		return null;
	}
	
	public Object lerUltimaVendaCadastrada() {
		try {
			FileInputStream fis = new FileInputStream(ultimaVendaCadastrada);
			ObjectInputStream oos = new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado em nossa base!");
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

		return null;
	}

}