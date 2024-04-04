package controller;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdicionarAlimento {
    static Scanner sc = new Scanner(System.in);
  
    public static void cadastrarAlimento() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("alimento.txt", true))) {
            System.out.println("-----Cadastro de Alimento-----");
            
            int codigo;
            String nome;
            String descricao;
            int quantidade;
            double preco;
            String validade;

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

            System.out.print("Digite a validade do produto (formato: AAAA-MM-DD): ");
            validade = sc.next();
            writer.write("Validade: " + validade + "\n");

            System.out.println("Alimento cadastrado com sucesso.");

            
            gravaEstoque(codigo, nome, descricao, quantidade, preco, validade);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco, String validade) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt", true))) {
            writer.write("Código: " + codigo + "\n");
            writer.write("Nome: " + nome + "\n");
            writer.write("Descrição: " + descricao + "\n");
            writer.write("Quantidade: " + quantidade + "\n");
            writer.write("Preço: " + preco + "\n");
            writer.write("Validade: " + validade + "\n");
            writer.write("\n");
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

    public static void listarAlimentos() {
        System.out.println("-------Listar Alimentos-------");
        String content = readFromFile("alimento.txt");
        System.out.println("Conteúdo lido do arquivo: ");
        System.out.println(content);
    }
}
