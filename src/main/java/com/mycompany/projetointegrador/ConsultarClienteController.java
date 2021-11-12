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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author lmato
 */
public class ConsultarClienteController implements Initializable {

    @FXML
    private TableView<LinhaTabelaCliente> tableCliente;
    @FXML
    private TableColumn<LinhaTabelaCliente, String> colunaNome;
    @FXML
    private TableColumn<LinhaTabelaCliente, String> colunaSobrenome;
    @FXML
    private TableColumn<LinhaTabelaCliente, String> colunaTelPrincipal;
    @FXML
    private TableColumn<LinhaTabelaCliente, String> colunaEmail;
    @FXML
    private TableColumn<LinhaTabelaCliente, String> colunaCpf;
    @FXML
    private TextField txtCpf;
    @FXML
    private TableColumn<LinhaTabelaCliente, Integer> colunaId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaId.setCellValueFactory(new PropertyValueFactory("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        colunaTelPrincipal.setCellValueFactory(new PropertyValueFactory("telPrincipal"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("cpf"));

        //LinhaTabelaCliente linha = new LinhaTabelaCliente (25,"Luan","Matos","11964245587","lmatos@gmail.com","569.895.785-08");
        //tableCliente.getItems().add(linha);
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
