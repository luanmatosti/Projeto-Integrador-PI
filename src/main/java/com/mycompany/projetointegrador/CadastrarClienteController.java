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
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lmato
 */
public class CadastrarClienteController implements Initializable {

    @FXML
    private TextField txtCep;
    @FXML
    private TextField txtLogradouro;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtComplemento;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtEstado;
    @FXML
    private DatePicker dtNascimento;
    @FXML
    private TextField txtRg;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtTelPrincipal;
    @FXML
    private TextField txtTelSecundario;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSobrenome;
    @FXML
    private ComboBox comboGenero;
    @FXML
    private ComboBox comboEstadoCivil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      comboGenero.getItems().add("Masculino");
      comboGenero.getItems().add("Feminino");
      comboEstadoCivil.getItems().add("Solteiro(a)");
      comboEstadoCivil.getItems().add("Casado(a)");
      comboEstadoCivil.getItems().add("Divorciado(a)");
      comboEstadoCivil.getItems().add("Viuvo(a)");
      comboEstadoCivil.getItems().add("União Estável");
    }

    @FXML
    private void limpar(ActionEvent event) {
        txtCep.clear();
txtLogradouro.clear();
txtNumero.clear();
txtComplemento.clear();
txtBairro.clear();
txtCidade.clear();
txtEstado.clear();
dtNascimento.setValue(null);
txtRg.clear();
txtCpf.clear();
txtTelPrincipal.clear();
txtTelSecundario.clear();
txtEmail.clear();
txtNome.clear();
txtSobrenome.clear();
comboGenero.getSelectionModel().clearSelection();
comboEstadoCivil.getSelectionModel().clearSelection();
    }

    @FXML
    private void cadastrar(ActionEvent event) {
     String sql = "INSERT INTO cliente (nome,sobrenome,dtNascimento,rg,cpf,genero,estadoCivil,cep,logradouro,numero,complemento,bairro,cidade,estado,telPricipal,telSecundario,email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
