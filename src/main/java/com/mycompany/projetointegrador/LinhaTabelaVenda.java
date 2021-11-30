/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetointegrador;

/**
 *
 * @author lssch
 */
public class LinhaTabelaVenda {

    private int colunaCodigo;
    private String colunaProduto;
    private int ColunaQtd;
    private float ColunaValor;

    public LinhaTabelaVenda(int colunaCodigo, String colunaProduto, int ColunaQtd, float ColunaValor) {
        this.colunaCodigo = colunaCodigo;
        this.colunaProduto = colunaProduto;
        this.ColunaQtd = ColunaQtd;
        this.ColunaValor = ColunaValor;
    }

    public int getColunaCodigo() {
        return colunaCodigo;
    }

    public void setColunaCodigo(int colunaCodigo) {
        this.colunaCodigo = colunaCodigo;
    }

    public String getColunaProduto() {
        return colunaProduto;
    }

    public void setColunaProduto(String colunaProduto) {
        this.colunaProduto = colunaProduto;
    }

    public int getColunaQtd() {
        return ColunaQtd;
    }

    public void setColunaQtd(int ColunaQtd) {
        this.ColunaQtd = ColunaQtd;
    }

    public float getColunaValor() {
        return ColunaValor;
    }

    public void setColunaValor(float ColunaValor) {
        this.ColunaValor = ColunaValor;
    }

}
