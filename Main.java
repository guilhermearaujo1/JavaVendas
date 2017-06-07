package projetovendas;


//import java.text.ParseException;
//import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int op = 0, i = 0, maxVenda = 3;
		Venda conj[] = new Venda[100];
		Cliente c, ultimoClienteCadastrado;
		Vendedor v, ultimoVendedorCadastrado;
		Produto p, ultimoProdutoCadastrado;
		String op1, npd, nvd, ncl, nVenda;
		Venda venda, ultimaVendaCadastrada;
		Menu menu = new Menu();
		Persist persist = new Persist();
		Validacao validaString = new Validacao();
		boolean isDadoNulo1, isDadoNulo2;
		double aux = 0.0;
		boolean loop = true;
		
		do{
			if (i < conj.length) {
				op = menu.menuPrincipal();
				switch (op) {
			
				case 1: // Cadastrar uma venda
					try{
						/* ==================== ==================== ==================== */
						/* 		==================== Vendedor ==================== */
						/* ==================== ==================== ==================== */
						
						nvd = JOptionPane.showInputDialog(null, "Digite o nome do Vendedor: ");
						isDadoNulo1 = validaString.isDadoInformadoNulo(nvd);
						
						while (isDadoNulo1){
							nvd = JOptionPane.showInputDialog(null, "Digite o nome do Vendedor: ");
							isDadoNulo1 = validaString.isDadoInformadoNulo(nvd);
						}
						
						v = (Vendedor) persist.lerVendedor(nvd); // Tenta Ler o vendedor
	
						// Tentar pegar o nome, caso seja nulo irá entrar no catch
						try {
							System.out.println(v.getNome()); // Se existir ele irá pular diretamente para o Cliente
						} catch (NullPointerException npe) {
							JOptionPane.showMessageDialog(null,
									"Vendedor não encontrado.\n" + "Prossiga para cadastrar um novo vendedor");
							v = new Vendedor((JOptionPane.showInputDialog("Digite nome do Vendedor: ")),
									JOptionPane.showInputDialog("Digite endereço do Vendedor: "));
							
							isDadoNulo1 = validaString.isDadoInformadoNulo(v.getNome());
							isDadoNulo2 = validaString.isDadoInformadoNulo(v.getEndereco());
							
							while (isDadoNulo1 || isDadoNulo2){
								v = new Vendedor((JOptionPane.showInputDialog("Digite nome do Vendedor: ")),
										JOptionPane.showInputDialog("Digite endereço do Vendedor: "));
								isDadoNulo1 = validaString.isDadoInformadoNulo(v.getNome());
								isDadoNulo2 = validaString.isDadoInformadoNulo(v.getEndereco());
							}
	
							try {
								ultimoVendedorCadastrado = (Vendedor) persist.lerUltimoVendedorCadastrado();
								v.setCod((ultimoVendedorCadastrado.getCod()) + 1);
								v.setIdVendedor((ultimoVendedorCadastrado.getCod()) + 1);
							} catch (NullPointerException n) { 
								System.out.println("Primeira execução");
							}
							
							persist.salvarVendedor(v, v.getNome());
	
						}					
	
						/* ==================== ==================== ==================== */
						/* 		==================== Cliente ==================== */
						/* ==================== ==================== ==================== */
						
						ncl = JOptionPane.showInputDialog(null, "Digite o nome do Cliente: ");
						isDadoNulo1 = validaString.isDadoInformadoNulo(ncl);
						
						while (isDadoNulo1){
							ncl = JOptionPane.showInputDialog(null, "Digite o nome do Cliente: ");
							isDadoNulo1 = validaString.isDadoInformadoNulo(ncl);
						}
	
						c = (Cliente) persist.lerCliente(ncl);
						
						try {
							System.out.println(c.getNome());
						} catch (NullPointerException npe) {
							JOptionPane.showMessageDialog(null,
									"Cliente não encontrado.\n" + "Prossiga para cadastrar um novo Cliente");
							c = new Cliente((JOptionPane.showInputDialog("Digite nome do cliente: ")),
									JOptionPane.showInputDialog("Digite endereço do cliente: "));
							
							isDadoNulo1 = validaString.isDadoInformadoNulo(c.getNome());
							isDadoNulo2 = validaString.isDadoInformadoNulo(c.getEnd());
							
							while (isDadoNulo1 || isDadoNulo2){
								c = new Cliente((JOptionPane.showInputDialog("Digite nome do cliente: ")),
										JOptionPane.showInputDialog("Digite endereço do cliente: "));
								
								isDadoNulo1 = validaString.isDadoInformadoNulo(c.getNome());
								isDadoNulo2 = validaString.isDadoInformadoNulo(c.getEnd());
							}
	
							try {
								ultimoClienteCadastrado = (Cliente) persist.lerUltimoClienteCadastrado();
								c.setCod((ultimoClienteCadastrado.getCod()) + 1);
								c.setIdCliente((ultimoClienteCadastrado.getCod()) + 1);
							} catch (NullPointerException n) {
								System.out.println("Primeira execução");
							}
	
							persist.salvarCliente(c, c.getNome());
						}
	
						// Prosseguir com a venda
						try {
	
							conj[i] = new Venda(maxVenda, c, v);
	
							do {
	
								/* ==================== ==================== ==================== */
								/* 		==================== Produto ==================== */
								/* ==================== ==================== ==================== */
								
								npd = JOptionPane.showInputDialog(null, "Digite o nome do Produto: ");
								isDadoNulo1 = validaString.isDadoInformadoNulo(npd);
								
								while (isDadoNulo1){
									npd = JOptionPane.showInputDialog(null, "Digite o nome do Produto: ");
									isDadoNulo1 = validaString.isDadoInformadoNulo(npd);
								}
								
								p = (Produto) persist.lerProduto(npd);
								
								try {
									System.out.println(p.getDescricao());
								} catch (NullPointerException npe) {
									JOptionPane.showMessageDialog(null,
											"Produto não encontrado.\n" + "Prossiga para cadastrar um novo");
									p = new Produto((JOptionPane.showInputDialog("Digite o nome do produto: ")),
											Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: ")));
									
									isDadoNulo1 = validaString.isDadoInformadoNulo(p.getDescricao());
									isDadoNulo2 = validaString.isDadoInformadoNulo(Double.toString(p.getVal()));
									
									while (isDadoNulo1 || isDadoNulo2){
										p = new Produto((JOptionPane.showInputDialog("Digite o nome do produto: ")),
												Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: ")));
										
										isDadoNulo1 = validaString.isDadoInformadoNulo(p.getDescricao());
										try{
											isDadoNulo2 = validaString.isDadoInformadoNulo(Double.toString(p.getVal()));
										}catch (NumberFormatException nfe){
											isDadoNulo2 = true;
										}
									}
	
									try {
										ultimoProdutoCadastrado = (Produto) persist.lerUltimoProdutoCadastrado();
										p.setCod((ultimoProdutoCadastrado.getCod()) + 1);
										p.setIdProduto((ultimoProdutoCadastrado.getCod()) + 1);
									} catch (NullPointerException n) {
										System.out.println("Primeira execução");
									}
									
									persist.salvarProduto(p, p.getDescricao());
	
								}
	
								if (conj[i].adicProduto(p) == false) {
									JOptionPane.showMessageDialog(null, "Erro: Atingiu o limite max de produtos na venda.");
								}
	
								try {
									ultimaVendaCadastrada = (Venda) persist.lerUltimaVendaCadastrada();
									conj[i].setCod(ultimaVendaCadastrada.getCod() + 1);
									conj[i].setIdVenda(ultimaVendaCadastrada.getCod() + 1);
								} catch (NullPointerException n) {
									System.out.println("Primeira execução");
								}
	
								
								op1 = JOptionPane.showInputDialog("Deseja cadastrar uma nova venda ?('S' OU 'N')");
								while((!op1.equalsIgnoreCase("n")) && (!op1.equalsIgnoreCase("s"))){
									op1 = JOptionPane.showInputDialog("'S' OU 'N'");
									
									
								}
	
							} while(op1.equalsIgnoreCase("S")); // fim do Do While
	
							persist.salvarVenda(conj[i], Integer.toString(conj[i].getCod()));
							aux = conj[i].calculaComissao(conj[i].getTotalVenda());
							v.setComissao(aux);
							persist.salvarVendedor(v, v.getNome()); // atualizar vendedor
	
							JOptionPane.showMessageDialog(null,
									c.toString() + "\nValor da Venda R$: " + conj[i].getTotalVenda() 
									+ "\nID do Vendedor: "	+ v.getCod() + "\nNome: " + v.getNome() + 
									"\nComissão da Venda: R$ "	+ String.format("%.2f", aux));
	
						} catch (NullPointerException npe) {
							JOptionPane.showMessageDialog(null, "Erro: Dados mal informados.");
							break;
						} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(null, "Erro: Dados mal informados.");
						}
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Erro: Dados mal informados.");
					}
					break;
			
				case 2: // Cadastrar um Produto
					try{
						p = new Produto((JOptionPane.showInputDialog("Digite o nome do produto: ")),
								Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: ")));

						isDadoNulo1 = validaString.isDadoInformadoNulo(p.getDescricao());
						isDadoNulo2 = validaString.isDadoInformadoNulo(Double.toString(p.getVal()));
						
						while (isDadoNulo1 || isDadoNulo2){
							p = new Produto((JOptionPane.showInputDialog("Digite o nome do produto: ")),
									Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: ")));
							
							isDadoNulo1 = validaString.isDadoInformadoNulo(p.getDescricao());
							try{
								isDadoNulo2 = validaString.isDadoInformadoNulo(Double.toString(p.getVal()));
							}catch (NumberFormatException nfe){
								isDadoNulo2 = true;
							}
						}
	
						try {
							ultimoProdutoCadastrado = (Produto) persist.lerUltimoProdutoCadastrado();
							p.setCod((ultimoProdutoCadastrado.getCod()) + 1);
							p.setIdProduto((ultimoProdutoCadastrado.getCod()) + 1);
						} catch (NullPointerException n) { 
							System.out.println("Primeira execução");
						}
						
						persist.salvarProduto(p, p.getDescricao());
						
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}
					
					break;

				case 3: // Cadastrar um vendedor
					try{
						v = new Vendedor((JOptionPane.showInputDialog("Digite nome do Vendedor: ")),
								JOptionPane.showInputDialog("Digite endereço do Vendedor: "));
						
						isDadoNulo1 = validaString.isDadoInformadoNulo(v.getNome());
						isDadoNulo2 = validaString.isDadoInformadoNulo(v.getEndereco());
						
						while (isDadoNulo1 || isDadoNulo2){
							v = new Vendedor((JOptionPane.showInputDialog("Digite nome do Vendedor: ")),
									JOptionPane.showInputDialog("Digite endereço do Vendedor: "));
							isDadoNulo1 = validaString.isDadoInformadoNulo(v.getNome());
							isDadoNulo2 = validaString.isDadoInformadoNulo(v.getEndereco());
						}
					
						try {
							ultimoVendedorCadastrado = (Vendedor) persist.lerUltimoVendedorCadastrado();
							v.setCod((ultimoVendedorCadastrado.getCod()) + 1);
							v.setIdVendedor((ultimoVendedorCadastrado.getCod()) + 1);
						} catch (NullPointerException n) { 
							System.out.println("Primeira execução");
						}
						
						persist.salvarVendedor(v, v.getNome());
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}
					
					break;

				case 4: // Cadastrar um cliente
					try{
						c = new Cliente((JOptionPane.showInputDialog("Digite nome do cliente: ")),
								JOptionPane.showInputDialog("Digite endereço do cliente: "));
						
						isDadoNulo1 = validaString.isDadoInformadoNulo(c.getNome());
						isDadoNulo2 = validaString.isDadoInformadoNulo(c.getEnd());
						
						while (isDadoNulo1 || isDadoNulo2){
							c = new Cliente((JOptionPane.showInputDialog("Digite nome do cliente: ")),
									JOptionPane.showInputDialog("Digite endereço do cliente: "));
							
							isDadoNulo1 = validaString.isDadoInformadoNulo(c.getNome());
							isDadoNulo2 = validaString.isDadoInformadoNulo(c.getEnd());
						}
					
						try {
							ultimoClienteCadastrado = (Cliente) persist.lerUltimoClienteCadastrado();
							c.setCod((ultimoClienteCadastrado.getCod()) + 1);
							c.setIdCliente((ultimoClienteCadastrado.getCod()) + 1);
						} catch (NullPointerException n) { 
							System.out.println("Primeira execução");
						}
	
						persist.salvarCliente(c, c.getNome());
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}
					
					break;

				case 5: // Listar uma venda
					try{
						nVenda = JOptionPane.showInputDialog(null, "Digite o codigo da Venda: ");
						isDadoNulo1 = validaString.isDadoInformadoNulo(nVenda);
						
						while (isDadoNulo1){
							nVenda = JOptionPane.showInputDialog(null, "Digite o codigo da Venda: ");
							isDadoNulo1 = validaString.isDadoInformadoNulo(nVenda);
						}
						
						try {
							venda = (Venda) persist.lerVenda(nVenda);
							JOptionPane.showMessageDialog(null, venda.toString());
						} catch (NullPointerException npe) {
							JOptionPane.showMessageDialog(null, "Não foram encontradas vendas com este código!");
						}
						
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}
					
					break;

				case 6: // Listar um produto
					try{
						npd = JOptionPane.showInputDialog(null, "Digite o nome do Produto: ");
						isDadoNulo1 = validaString.isDadoInformadoNulo(npd);
						
						while (isDadoNulo1){
							npd = JOptionPane.showInputDialog(null, "Digite o nome do Produto: ");
							isDadoNulo1 = validaString.isDadoInformadoNulo(npd);
						}
						
						try {
							p = (Produto) persist.lerProduto(npd);
							JOptionPane.showMessageDialog(null, p.toString());
						} catch (NullPointerException npe) {
							JOptionPane.showMessageDialog(null, "Este produto não está cadastrado!");
						}
						
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}
					
					break;

				case 7: // Listar um vendedor
					try{
						nvd = JOptionPane.showInputDialog(null, "Digite o nome do Vendedor: ");
						isDadoNulo1 = validaString.isDadoInformadoNulo(nvd);
						
						while (isDadoNulo1){
							nvd = JOptionPane.showInputDialog(null, "Digite o nome do Vendedor: ");
							isDadoNulo1 = validaString.isDadoInformadoNulo(nvd);
						}
						
						try {
							v = (Vendedor) persist.lerVendedor(nvd);
							JOptionPane.showMessageDialog(null, v.toString());
						} catch (NullPointerException npe) {
							JOptionPane.showMessageDialog(null, "Este vendedor não está cadastrado!");
						}
						
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}
					
					break;

				case 8: // Listar um cliente
					try{
						ncl = JOptionPane.showInputDialog(null, "Digite o nome do Cliente: ");
						isDadoNulo1 = validaString.isDadoInformadoNulo(ncl);
						
						while (isDadoNulo1){
							ncl = JOptionPane.showInputDialog(null, "Digite o nome do Cliente: ");
							isDadoNulo1 = validaString.isDadoInformadoNulo(ncl);
						}
						
						try {
							c = (Cliente) persist.lerCliente(ncl);
							JOptionPane.showMessageDialog(null, c.toString());
						} catch (NullPointerException npe) {
							JOptionPane.showMessageDialog(null, "Este Cliente não está cadastrado!");
						}
						
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}
					
					break;

				case 9: // Listar ultima venda
					try {
						ultimaVendaCadastrada = (Venda) persist.lerUltimaVendaCadastrada();
						JOptionPane.showMessageDialog(null, ultimaVendaCadastrada.toString());
					} catch (NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Não há Vendas cadastradas");
					}
					
					break;

				case 10: // Listar ultimo produto
					try {
						ultimoProdutoCadastrado = (Produto) persist.lerUltimoProdutoCadastrado();
						JOptionPane.showMessageDialog(null, ultimoProdutoCadastrado.toString());
					} catch (NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Não há produtos cadastrados");
					}

					break;

				case 11: // Listar o ultimo vendedor cadastrado
					try {
						ultimoVendedorCadastrado = (Vendedor) persist.lerUltimoVendedorCadastrado();
						JOptionPane.showMessageDialog(null, ultimoVendedorCadastrado.toString());
					} catch (NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Não há vendedores cadastrados");
					}
					
					break;

				case 12: // Listar ultimo Cliente
					try {
						ultimoClienteCadastrado = (Cliente) persist.lerUltimoClienteCadastrado();
						JOptionPane.showMessageDialog(null, ultimoClienteCadastrado.toString());
					} catch (NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Não há clientes cadastrados");
					}
					
					break;

				case 13: // Colocar produto em promocao
					try{
						npd = JOptionPane.showInputDialog(null, "Digite o nome do Produto: ");
						isDadoNulo1 = validaString.isDadoInformadoNulo(npd);
						
						while (isDadoNulo1){
							npd = JOptionPane.showInputDialog(null, "Digite o nome do Produto: ");
							isDadoNulo1 = validaString.isDadoInformadoNulo(npd);
						}
						
						p = (Produto) persist.lerProduto(npd);
						JOptionPane.showMessageDialog(null, "Valor atual do produto: " + p.getVal());
						p.setValPromocao(
								Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o novo valor do produto?")));
						p.setIsProdutoPromocao(true);
						JOptionPane.showMessageDialog(null, "Novo valor: \n" + p.getValPromocao());
						persist.salvarProduto(p, npd);
						
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Este produto não está cadastrado!");
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}
					
					break;

				case 14: // Retirar produto de promocao
					try{
						npd = JOptionPane.showInputDialog(null, "Digite o nome do Produto: ");
						isDadoNulo1 = validaString.isDadoInformadoNulo(npd);
						
						while (isDadoNulo1){
							npd = JOptionPane.showInputDialog(null, "Digite o nome do Produto: ");
							isDadoNulo1 = validaString.isDadoInformadoNulo(npd);
						}
	
						p = (Produto) persist.lerProduto(npd);
						if(p.getIsProdutoPromocao()){
							JOptionPane.showMessageDialog(null, "Valor atual: " + p.getValPromocao());
						}
						else{
							JOptionPane.showMessageDialog(null, "Valor atual: " + p.getVal());
						}						
						p.setIsProdutoPromocao(false);
						p.setValPromocao(p.getVal());
						JOptionPane.showMessageDialog(null, "Novo valor: " + p.getValPromocao());
						persist.salvarProduto(p, npd);
						
					}catch (NullPointerException npe){
						JOptionPane.showMessageDialog(null, "Este produto não está cadastrado!");
					}catch (NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Valores não informados, finalizando operação.");
					}
					
					break;

				case 99:
					return;

				default:
					return;
				}

			} else
				JOptionPane.showMessageDialog(null, "Erro: Cadastro max de vendas atingida.");

			if (i == conj.length)
				break;
		}while(loop);
	}
}