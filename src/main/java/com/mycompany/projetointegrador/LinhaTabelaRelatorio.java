package com.mycompany.projetointegrador;

import java.time.LocalDate;

public class LinhaTabelaRelatorio {
    
private String colunaCliente;
private Integer colunaCodVenda;
private LocalDate colunaData;
private String colunaProduto;
private Integer colunaQtd;
private Double colunaTotal;

    public LinhaTabelaRelatorio(String colunaCliente, int colunaCodVenda, LocalDate colunaData, String colunaProduto, Integer colunaQtd, Double colunaTotal) {
        this.colunaCliente = colunaCliente;
        this.colunaCodVenda = colunaCodVenda;
        this.colunaData = colunaData;
        this.colunaProduto = colunaProduto;
        this.colunaQtd = colunaQtd;
        this.colunaTotal = colunaTotal;
    }

    public String getcolunaCliente() {
        return colunaCliente;
    }

    public void setcolunaCliente(String colunaCliente) {
        this.colunaCliente = colunaCliente;
    }

    public Integer getcolunaCodVenda() {
        return colunaCodVenda;
    }

    public void setcolunaCodVenda(Integer colunaCodVenda) {
        this.colunaCodVenda = colunaCodVenda;
    }

    public LocalDate getcolunaData() {
        return colunaData;
    }

    public void setcolunaData(LocalDate colunaData) {
        this.colunaData = colunaData;
    }

    public String getcolunaProduto() {
        return colunaProduto;
    }

    public void setcolunaProduto(String colunaProduto) {
        this.colunaProduto = colunaProduto;
    }

    public Integer getcolunaQtd() {
        return colunaQtd;
    }

    public void setcolunaQtd(Integer colunaQtd) {
        this.colunaQtd = colunaQtd;
    }

    public Double getcolunaTotal() {
        return colunaTotal;
    }

    public void setcolunaTotal(Double colunaTotal) {
        this.colunaTotal = colunaTotal;
    }

}
