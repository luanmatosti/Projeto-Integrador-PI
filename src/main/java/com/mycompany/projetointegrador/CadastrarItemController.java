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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lmato
 */
public class CadastrarItemController implements Initializable {

    @FXML
    private TextField txtAutor;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtEditora;
    @FXML
    private DatePicker dtPublicacao;
    @FXML
    private TextField txtPagina;
    @FXML
    private ComboBox<?> comboGeneroLiterario;
    @FXML
    private TextField txtPreco;

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
    private void cadastrar(ActionEvent event) {
    }
    
}
