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
public class ConsultarItemController implements Initializable {

    @FXML
    private TableView<?> tableProduto;
    @FXML
    private TableColumn<?, ?> colunaTituto;
    @FXML
    private TableColumn<?, ?> colunaAutor;
    @FXML
    private TableColumn<?, ?> colunaAssunto;
    @FXML
    private TableColumn<?, ?> colunaPreco;
    @FXML
    private TableColumn<?, ?> colunaEstoque;
    @FXML
    private TextField txtPesquisa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void limpar(ActionEvent event) {
    }

    @FXML
    private void pesquisar(ActionEvent event) {
    }

    @FXML
    private void alterar(ActionEvent event) {
    }

    @FXML
    private void deletar(ActionEvent event) {
    }
    
}
