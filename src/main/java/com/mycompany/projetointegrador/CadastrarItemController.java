/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetointegrador;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
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
    private ComboBox comboCategoria;
    @FXML
    private TextField txtPreco;
    @FXML
    private TextField txtQtd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboCategoria.getItems().add("Suspense");
        comboCategoria.getItems().add("Romance");
    }

    @FXML
    private void limpar(ActionEvent event) {
    }

    @FXML
    private void cadastrar(ActionEvent event) {
        String sql = "INSERT INTO produto (autor, titulo, editora, dtPublicacao, nmrPagina, categoria, preco, qtd) VALUES (?,?,?,?,?,?,?,?)";

        try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
            ps.setString(1, txtAutor.getText());
            ps.setString(2, txtTitulo.getText());
            ps.setString(3, txtEditora.getText());
            ps.setDate(4, Date.valueOf(dtPublicacao.getValue()));
            ps.setInt(5, Integer.parseInt(txtPagina.getText()));
            ps.setString(6, comboCategoria.getSelectionModel().getSelectedItem().toString());
            ps.setDouble(7, Double.parseDouble(txtPreco.getText()));
            ps.setInt(8, Integer.parseInt(txtQtd.getText()));

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
