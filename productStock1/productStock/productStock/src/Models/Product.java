package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Product {
	private int codigo;
	private String nome;
	private String descricao;
	private int quantidade;
	private double preco;
	public Product(int codigo, String nome, String descricao, int quantidade, double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	  public String exibirDetalhes() {
	        return "Código: " + codigo + "\n" + "Nome: " + nome + "\n" +"Descrição: " + descricao + "\n" +"Quantidade: " + quantidade + "\n" +"Preço: " + preco + "\n";
	    }
	  public static void gravaEstoque(String fileName) {
	        System.out.println("Visualizando estoque de " + fileName + ":");

	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;

	         
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (Exception e) {
	            System.out.println("Erro ao ler do arquivo: " + e.getMessage());
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
}
