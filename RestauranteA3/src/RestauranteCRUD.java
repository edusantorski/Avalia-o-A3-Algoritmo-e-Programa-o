/* ================= AVALIAÇÃO A3 ==========================
 * 
 * UC: Algorítmo e Programação
 * Orientador: Prof. João Armênio
 * Universidade UNICURITIBA
 * Campus: Milton Viana
 * 
 * ================= PROPOSTA ==============================
 * 
 * Criar um programa CRUD em JAVA, sem interface gráfica.
 * O tema escolhido pela equipe foi sistema de gestão de fichas para restaurantes, bares e lanchonetes.
 * 
 * ================= AUTORES ===============================

 * Criado por:
 * Eduardo Roberto Marques    | RA: 942617156
 * Gabriela dos Santos Costa  | RA: 942611458
 * Henrique de Lima Martines  | RA: 942613241
 *
 */

import java.util.Scanner;

public class RestauranteCRUD {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Variáveis do número total de pedidos e da opção digitada no menu.
        int opcao;
        int totalPedidos = 0;

        //Definição dos vetores/arrays das fichas, com as informações gerais do pedido cadastrado.
        int[] numeroPedido = new int[100];
        int[] numeroMesa = new int[100];
        
        String[] nomeCliente = new String[100];
        String[] itens = new String[100];

        //Exibição de mensagem de inicialização
        inicio(); 
        
        
        //Início do looping de menu, encerrado apenas se for digitada a opção 5.
        do {
            menu();

            //Leitura da opção digitada através do teclado sc.
            opcao = sc.nextInt();
            sc.nextLine(); 

            //Inicio do switch case com as 5 opções do menu.
            switch (opcao) {

                case 1:
                	strLn("\n--- Criar Pedido ---");

                    str("Número do pedido: ");
                    // Faz a leitura dos dados do pedido e armazena no vetor da quantidade total de pedidos;
                    numeroPedido[totalPedidos] = sc.nextInt();
                    sc.nextLine();

                    str("Nome do cliente: ");
                    nomeCliente[totalPedidos] = sc.nextLine();

                    str("Número da mesa: ");
                    numeroMesa[totalPedidos] = sc.nextInt();
                    sc.nextLine();

                    str("Itens do pedido: ");
                    itens[totalPedidos] = sc.nextLine();
                    
                    // Atualiza o vetor para que o próximo pedido cadastrado ocupe o vetor ++.
                    totalPedidos++;

                    strLn("Pedido cadastrado com sucesso!");
                    break;

                case 2:
                	strLn("\n--- Lista de Pedidos ---");
                    
                    //Condicional para verificar se há algum pedido cadastrado.
                    if (totalPedidos == 0) {
                    	strLn("Nenhum pedido cadastrado.");
                    } else { //Impressão de todos os pedidos cadastrados através de looping "for".
                        for (int i = 0; i < totalPedidos; i++) {
                        	strLn("\nPedido #" + numeroPedido[i]);
                            strLn("Cliente: " + nomeCliente[i]);
                            strLn("Mesa: " + numeroMesa[i]);
                            strLn("Itens: " + itens[i]);
                        }
                    }
                    break;

                case 3:
                	strLn("\n--- Atualizar Pedido ---");

                    str("Digite o número do pedido: ");
                    int busca = sc.nextInt(); //Leitura da variável "busca" para gravar o pedido a ser pesquisado.
                    sc.nextLine();
                    
                    boolean encontrado = false; //Definição de variával booleana para validar se pedido existe ou não existe.

                    //Inicio de looping para checar todas as fichas cadastradas no Array e localizar "busca"
                    for (int i = 0; i < totalPedidos; i++) {
                        if (numeroPedido[i] == busca) {

                        	//Impressão do pedido
                        	strLn("=== Pedido Localizado ===");
                        	strLn("\nPedido #" + numeroPedido[i]);
                            strLn("Cliente: " + nomeCliente[i]);
                            strLn("Mesa: " + numeroMesa[i]);
                            strLn("Itens: " + itens[i]);
                            
                        	int opcaoAtualizar = 0;
                        	
                            do {
                            		menuAtualizar(); //Impressão do menu de opções de atualizar pedido
                            		
                            	    opcaoAtualizar = sc.nextInt();//Leitura da opção escolhida no menu
                            	    sc.nextLine();//Limpeza do buffer do sc
                            		
                            		switch (opcaoAtualizar) {
                            		case 1: 
                            			str("Novo nome do cliente: "); //Ler novo valor de nome
        	                            nomeCliente[i] = sc.nextLine();
        	                            break;
                            			
                            		case 2:
                            			str("Novo número da mesa: "); //Ler novo nr da mesa
         	                            numeroMesa[i] = sc.nextInt();
         	                            sc.nextLine(); //Limpar buffer do sc.
                            			break; 
                            			
                            		case 3: 
                            			str("Novos itens: "); //Ler novos itens cadastrados
        	                            itens[i] = sc.nextLine();
                            			break;
                            			
                            		case 4: 
                            			str("Pedido atualizado!");
                            			break;
                            			
                            			default: strLn("Opção inválida.");
                            		}
                            } while (opcaoAtualizar != 4);                            	  
    
	                            encontrado = true; //Alterar variável boleanda para verdadeiro = pedido encotrado.
	                            strLn("\nRetornando ao menu inicial.");
                        }
                    }

                    if (!encontrado) { //Condicional para validar se o pedido não foi encontrado, imprime "não encontrado"
                    	strLn("Pedido não encontrado.");
                    }
                    break;

                case 4:
                	strLn("\n=== Remover Pedido ===");

                    str("Digite o número do pedido: ");
                    int remover = sc.nextInt(); //Leitura do nr de pedido a ser "removido"

                    boolean removido = false; //Variável de confirmação se o pedido foi encontrado.

                    //Início da verificação do pedido a ser removido
                    for (int i = 0; i < totalPedidos; i++) {
                        if (numeroPedido[i] == remover) { //Condicional caso o pedido digitado seja encontrado

                            for (int x = i; x < totalPedidos - 1; x++) { //Inicio de looping for para reorganizar os arrays seguintes, 
                                numeroPedido[x] = numeroPedido[x + 1];
                                nomeCliente[x] = nomeCliente[x + 1];
                                numeroMesa[x] = numeroMesa[x + 1];
                                itens[x] = itens[x + 1];
                            }

                            totalPedidos--; // Diminui a qtd. total de pedidos registrados no contador após remoção do pedido
                            removido = true; //Altera validação para verdadeira

                            strLn("Pedido removido!");
                            break;
                        }
                    }

                    if (!removido) { //Caso não encontre o número digitado.
                    	strLn("Pedido não encontrado.");
                    }
                    break;

                case 5:
                	strLn("Encerrando o sistema...");
                    break;

                default:
                	strLn("Opção inválida! Tente novamente.");
            }

        } while (opcao != 5); //Condicional de looping do menu.

        sc.close();
    }

	public static void strLn (String x) {
		System.out.println(x);
	}

	public static void str (String x) {
		System.out.print(x);
	}

	public static void menuAtualizar() {
		strLn("\n\n=== Atualizar ===");
	    strLn("[1] - Alterar nome do Cliente");
	    strLn("[2] - Alterar número da mesa");
	    strLn("[3] - Alterar itens do pedido");
	    strLn("[4] - Retornar ao menu inicial");
	    strLn("\nDigite uma opção:");
	}

	public static void menu () {
		strLn("\n\n======= MENU =======");
		strLn("[1] - Criar pedido");
	    strLn("[2] - Listar pedidos");
	    strLn("[3] - Atualizar pedido");
	    strLn("[4] - Remover pedido");
	    strLn("[5] - Sair");
	    str("\nDigite uma opção: ");
	
	}

	public static void inicio () {
		strLn("\n=========================");
	    strLn("\n| PROGRAMA DE FICHA PARA |");
	    strLn("\n|  RESTAURANTES E BARES  |");
	    strLn("\n=========================");
	}
    
}
