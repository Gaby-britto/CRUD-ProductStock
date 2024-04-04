package Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Alimento extends Product{

	private LocalDate dataValidade; 
	public Alimento(int codigo, String nome, String descricao, int quantidade, double preco, LocalDate dataValidade) {
		super(codigo, nome, descricao, quantidade, preco);
		this.dataValidade = dataValidade;
	}
	public LocalDate getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
		@Override
		public String exibirDetalhes() {
		    return super.exibirDetalhes() + "\nData de validade: " + dataValidade;
		}


    public void gravaEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt", true))) {
            writer.write(exibirDetalhes());
            writer.newLine();
            System.out.println("Dados do produto gravados com sucesso no arquivo estoque.txt.");
        } catch (IOException e) {
            System.out.println("Erro ao gravar os dados do produto no arquivo: " + e.getMessage());
        }
    }
	
}
