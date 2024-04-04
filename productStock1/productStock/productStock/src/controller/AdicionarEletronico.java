package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdicionarEletronico {
    static Scanner sc = new Scanner(System.in);

    static void cadastrarEletronico() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("eletronico.txt", true))) {
            writer.newLine();
            System.out.println("-----Cadastro de Eletrônico-----");
  
            int codigo;
            String nome;
            String descricao;
            int quantidade;
            double preco;
            String marca;
            String modelo;
   
            do {
                try {
                    System.out.print("Digite o código do produto: ");
                    codigo = sc.nextInt();
                    writer.write("Código: " + codigo + "\n");
                    break; 
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Certifique-se de inserir um número inteiro.");
                    sc.nextLine(); 
                }
            } while (true);

            
            System.out.print("Digite o nome do produto: ");
            nome = sc.next();
            writer.write("Nome: " + nome + "\n");

            
            System.out.print("Digite a descrição do produto: ");
            descricao = sc.next();
            writer.write("Descrição: " + descricao + "\n");

            
            do {
                try {
                    System.out.print("Digite a quantidade do produto: ");
                    quantidade = sc.nextInt();
                    writer.write("Quantidade: " + quantidade + "\n");
                    break;
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Certifique-se de inserir um número inteiro.");
                    sc.nextLine(); 
                }
            } while (true);

            
            System.out.print("Digite o preço do produto: ");
            preco = sc.nextDouble();
            writer.write("Preço: " + preco + "\n");

            
            System.out.print("Digite a marca do produto: ");
            marca = sc.next();
            writer.write("Marca: " + marca + "\n");

            
            System.out.print("Digite o modelo do produto: ");
            modelo = sc.next();
            writer.write("Modelo: " + modelo + "\n");

            System.out.println("Eletrônico cadastrado com sucesso.");
            gravaEstoque(codigo, nome, descricao, quantidade, preco, marca, modelo);
        } catch (IOException e) { 
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    protected static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

         
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n"); 
            }
        } catch (IOException e) { 
            System.out.println("Erro ao ler do arquivo: " + e.getMessage());
        }
        return content.toString(); 
    }

    public static void listarEletronicos() {
        System.out.println("-------Listar Eletrônicos-------");
        String content = readFromFile("eletronico.txt");
        System.out.println("Conteúdo lido do arquivo: ");
        System.out.println(content);
    }

    public static void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco, String marca, String modelo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt", true))) {
            writer.write("Código: "  + codigo + "\n");
            writer.write("Nome: "  + nome +  "\n");
            writer.write("Descrição: " + descricao + "\n");
            writer.write("Quantidade: " + quantidade + "\n");
            writer.write("Preço: " + preco + "\n");
            writer.write("Marca: " + marca + "\n");
            writer.write("Modelo: " + modelo + "\n");
            writer.write("\n");
            System.out.println("Dados do produto gravados no estoque com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
