/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetointegrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lmato
 */
public class VendaController implements Initializable {

    @FXML
    private TextField txtCodProduto;
    @FXML
    private TextField txtQtd;
    @FXML
    private TextField txtPreco;
    @FXML
    private TextField txtProduto;
    @FXML
    private TextField txtCpf;
    @FXML
    private TableView<?> tableVenda;
    @FXML
    private TableColumn<?, ?> colunaCodigo;
    @FXML
    private TableColumn<?, ?> colunaProduto;
    @FXML
    private TableColumn<?, ?> colunaQtd;
    @FXML
    private TableColumn<?, ?> colunaValor;
    @FXML
    private TableColumn<?, ?> colunaTotal;
    @FXML
    private TextField txtTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void adicionar(ActionEvent event) {
    }

    @FXML
    private void finalizar(ActionEvent event) {
    }

    @FXML
    private void remover(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }

}
