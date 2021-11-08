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
public class ConsultarClienteController implements Initializable {

    @FXML
    private TableView<?> tableCliente;
    @FXML
    private TableColumn<?, ?> colunaNome;
    @FXML
    private TableColumn<?, ?> colunaSobrenome;
    @FXML
    private TableColumn<?, ?> colunaTelPrincipal;
    @FXML
    private TableColumn<?, ?> colunaEmail;
    @FXML
    private TableColumn<?, ?> colunaCpf;
    @FXML
    private TextField txtCpf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void apagar(ActionEvent event) {
    }

    @FXML
    private void limpar(ActionEvent event) {
    }

    @FXML
    private void consultar(ActionEvent event) {
    }
    
}
