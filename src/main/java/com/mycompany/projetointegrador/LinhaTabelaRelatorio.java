package com.mycompany.projetointegrador;

import java.time.LocalDate;

public class LinhaTabelaRelatorio {
    
private String cliente;
private Integer codVenda;
private LocalDate data;
private String nomeProduto;
private Integer qtd;
private Double valor;

    public LinhaTabelaRelatorio(String cliente, int codVenda, LocalDate data, String nomeProduto, Integer qtd, Double valor) {
        this.cliente = cliente;
        this.codVenda = codVenda;
        this.data = data;
        this.nomeProduto = nomeProduto;
        this.qtd = qtd;
        this.valor = valor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
