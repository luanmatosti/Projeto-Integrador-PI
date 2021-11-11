package com.mycompany.projetointegrador;

public class LinhaTabelaProduto {

    private String titulo;
    private String autor;
    private String assunto;
    private double preco;
   private int estoque;

    public LinhaTabelaProduto(String titulo, String autor, String assunto, double preco, int estoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.assunto = assunto;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
