package controller;

import java.util.Scanner;

import Models.Product;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    protected static void menu() {
        int escolha;

        do {
            System.out.println("-----------------------------");
            System.out.println("             MENU            ");
            System.out.println("-----------------------------");
            System.out.println("1 - Criar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Visualizar Estoque");
            System.out.print("Escolha uma opção: ");

            try {
                escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        exibirMenuCadastrar();
                        break;
                    case 2:
                        exibirInformacoes();
                        break;
                    case 3:
                        Product.gravaEstoque("estoque.txt");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida! Certifique-se de inserir um número.");
                sc.nextLine();
                escolha = 0;
            }
        } while (escolha != 3);

        sc.close();
    }

    public static void exibirMenuCadastrar() {
        int escolha;

        do {
        	System.out.println("-----------------------------");
            System.out.println("Digite a opção correspondente");
            System.out.println("1 - Criar Produto Alimentício");
            System.out.println("2 - Criar Produto Eletrônico");
            System.out.println("3 - Voltar ao Menu Principal");

            try {
                escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        AdicionarAlimento.cadastrarAlimento();
                        break;
                    case 2:
                        AdicionarEletronico.cadastrarEletronico();
                        break;
                    case 3:
                        System.out.println("Voltando ao Menu Principal...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida! Certifique-se de inserir um número.");
                sc.nextLine();
                escolha = 0;
            }
        } while (escolha != 3);
    }

    public static void exibirInformacoes() {
        int escolha;

        do {
        	System.out.println("-----------------------------");
            System.out.println("Digite a opção correspondente");
            System.out.println("1 - Listar Produtos Alimentícios");
            System.out.println("2 - Listar Produtos Eletrônicos");
            System.out.println("3 - Voltar ao Menu Principal");

            try {
                escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Listando alimentos:");
                        AdicionarAlimento.listarAlimentos();
                        break;
                    case 2:
                        System.out.println("Listando eletrônicos:");
                        AdicionarEletronico.listarEletronicos();
                        break;
                    case 3:
                        System.out.println("Voltando ao Menu Principal...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida! Certifique-se de inserir um número.");
                sc.nextLine();
                escolha = 0;
            }
        } while (escolha != 3);
    }

}
