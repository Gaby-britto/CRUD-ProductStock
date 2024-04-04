package Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Eletronico extends Product {
    private String marca;
    private String modelo;

    public Eletronico(int codigo, String nome, String descricao, int quantidade, double preco, String marca,
            String modelo) {
        super(codigo, nome, descricao, quantidade, preco);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String exibirDetalhes() {
        super.exibirDetalhes();
		return "Marca: " + marca + "Modelo: " + modelo;
    }
    public void gravaEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt", true))) {
            writer.write(exibirDetalhes());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao gravar os dados do produto no arquivo: " + e.getMessage());
        }
    }
}
