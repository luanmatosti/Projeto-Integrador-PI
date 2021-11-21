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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    private TextField editProduto;
    @FXML
    private TextField editQtdProduto;
    @FXML
    private TextField editCpf;
    @FXML
    private DatePicker dataPedido;
    @FXML
    private TextField totalPedido;
    @FXML
    private Label labelCliente;

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
    private void finalizarPedido(ActionEvent event) {
    }

    @FXML
    private void removerProduto(ActionEvent event) {
    }

    @FXML
    private void cancelarPedido(ActionEvent event) {
    }

}
