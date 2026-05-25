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

        
        System.out.println("\n=========================");
        System.out.println("\n| PROGRAMA DE FICHA PARA |");
        System.out.println("\n|  RESTAURANTES E BARES  |");
        System.out.println("\n=========================");
        
        //Início do looping de menu, encerrado apenas se for digitada a opção 5.
        do {
            System.out.println("\n\n======= MENU =======");
            System.out.println("1 - Criar pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("3 - Atualizar pedido");
            System.out.println("4 - Remover pedido");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            //Leitura da opção digitada através do teclado sc.
            opcao = sc.nextInt();
            sc.nextLine(); 

            //Inicio do switch case com as 5 opções do menu.
            switch (opcao) {

                case 1:
                    System.out.println("\n--- Criar Pedido ---");

                    System.out.print("Número do pedido: ");
                    // Faz a leitura dos dados do pedido e armazena no vetor da quantidade total de pedidos;
                    numeroPedido[totalPedidos] = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome do cliente: ");
                    nomeCliente[totalPedidos] = sc.nextLine();

                    System.out.print("Número da mesa: ");
                    numeroMesa[totalPedidos] = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Itens do pedido: ");
                    itens[totalPedidos] = sc.nextLine();
                    
                    // Atualiza o vetor para que o próximo pedido cadastrado ocupe o vetor ++.
                    totalPedidos++;

                    System.out.println("Pedido cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Pedidos ---");
                    
                    //Condicional para verificar se há algum pedido cadastrado.
                    if (totalPedidos == 0) {
                        System.out.println("Nenhum pedido cadastrado.");
                    } else { //Impressão de todos os pedidos cadastrados através de looping "for".
                        for (int i = 0; i < totalPedidos; i++) {
                            System.out.println("\nPedido #" + numeroPedido[i]);
                            System.out.println("Cliente: " + nomeCliente[i]);
                            System.out.println("Mesa: " + numeroMesa[i]);
                            System.out.println("Itens: " + itens[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Atualizar Pedido ---");

                    System.out.print("Digite o número do pedido: ");
                    int busca = sc.nextInt(); //Variável "busca" para gravar o pedido a ser pesquisado;
                    sc.nextLine();
                    
                    boolean encontrado = false; //Definição de variával booleana para validar se pedido existe ou não existe.

                    //Inicio de looping para checar todas as fichas cadastradas no Array e localizar "busca"
                    for (int i = 0; i < totalPedidos; i++) {
                        if (numeroPedido[i] == busca) {

                            System.out.print("Novo nome do cliente: "); //Ler novo valor de nome
                            nomeCliente[i] = sc.nextLine();

                            System.out.print("Novo número da mesa: "); //Ler novo nr da mesa
                            numeroMesa[i] = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Novos itens: "); //Ler novos itens cadastrados
                            itens[i] = sc.nextLine();

                            encontrado = true; //Alterar variável boleanda para verdadeiro = pedido encotrado.
                            System.out.println("Pedido atualizado!");
                        }
                    }

                    if (!encontrado) { //Condicional para validar se o pedido não foi encontrado, imprime "não encontrado"
                        System.out.println("Pedido não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Remover Pedido ---");

                    System.out.print("Digite o número do pedido: ");
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

                            System.out.println("Pedido removido!");
                            break;
                        }
                    }

                    if (!removido) { //Caso não encontre o número digitado.
                        System.out.println("Pedido não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 5); //Condicional de looping do menu.

        sc.close();
    }
}