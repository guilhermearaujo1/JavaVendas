package projetovendas;

import javax.swing.JOptionPane;

public class Menu {	

	public int menuPrincipal(){
		int op = 0;
		try{
			op = Integer.parseInt((JOptionPane.showInputDialog("Digite opção:" + 
						"\n1 - Cadastrar uma Venda" + 
						"\n2 - Cadastrar um Produto" +
						"\n3 - Cadastrar um Vendedor" +
						"\n4 - Cadastrar um Cliente" +
						"\n5 - Listar uma Venda" +
						"\n6 - Listar um Produto" +
						"\n7 - Listar um Vendedor" +
						"\n8 - Listar um Cliente" +
						"\n9 - Listar ultima Venda cadastrada" +
						"\n10 - Listar ultimo Produto cadastrado" +
						"\n11 - Listar ultimo Vendedor cadastrado" +
						"\n12 - Listar ultimo Cliente cadastrado" +
						"\n13 - Colocar Produto em promoção" +
						"\n14 - Retirar Produto da promoção" +
						"\n99 - Sair ")));
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Deve ser informado apenas numeros");
				return 99;
			}; // sair
		
		return op;
	}
	
}