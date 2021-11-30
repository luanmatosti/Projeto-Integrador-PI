package com.mycompany.projetointegrador;

import java.time.LocalDate;

public class LinhaTabelaRelatorio {

    private String cliente;
    private Integer CodVenda;
    private LocalDate Data;
    private String Produto;
    private Integer Qtd;
    private Double Unitario;
    private Double Total;

    public LinhaTabelaRelatorio(String cliente, Integer CodVenda, LocalDate Data, String Produto, Integer Qtd, Double Unitario, Double Total) {
        this.cliente = cliente;
        this.CodVenda = CodVenda;
        this.Data = Data;
        this.Produto = Produto;
        this.Qtd = Qtd;
        this.Unitario = Unitario;
        this.Total = Total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getCodVenda() {
        return CodVenda;
    }

    public void setCodVenda(Integer CodVenda) {
        this.CodVenda = CodVenda;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate Data) {
        this.Data = Data;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    public Integer getQtd() {
        return Qtd;
    }

    public void setQtd(Integer Qtd) {
        this.Qtd = Qtd;
    }

    public Double getUnitario() {
        return Unitario;
    }

    public void setUnitario(Double Unitario) {
        this.Unitario = Unitario;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

}
