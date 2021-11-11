/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetointegrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author lmato
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private BorderPane container;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void abrirCadastrarCliente(ActionEvent event) throws IOException {
        App.setRoot("CadastrarCliente", container);
    }

    @FXML
    private void abrirConsultarCliente(ActionEvent event) throws IOException {
        App.setRoot("ConsultarCliente", container);
    }

    @FXML
    private void abrirCadastrarItens(ActionEvent event) throws IOException {
        App.setRoot("CadastrarItem", container);
    }

    @FXML
    private void abrirConsultarItens(ActionEvent event) throws IOException {
        App.setRoot("ConsultarItem", container);
    }

    @FXML
    private void abrirVenda(ActionEvent event) throws IOException {
        App.setRoot("Venda", container);
    }

    @FXML
    private void abrirRelatorio(ActionEvent event) throws IOException {
        App.setRoot("Relatorio", container);
    }

}
