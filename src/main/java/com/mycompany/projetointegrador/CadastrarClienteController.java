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
     String sql = "INSERT INTO cliente (nome,sobrenome,dtNascimento,rg,cpf,genero,estadoCivil,cep,logradouro,numero,complemento,bairro,cidade,estado,telPrincipal,telSecundario,email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
            //nome
            ps.setString(1, txtNome.getText());
            //sobrenome
            ps.setString(2, txtSobrenome.getText());
            //dtNascimento
            ps.setDate(3, Date.valueOf(dtNascimento.getValue()));           
            //rg
            ps.setString(4, txtRg.getText());
            //cpf
            ps.setString(5, txtCpf.getText());
            //genero
            ps.setString(6, comboGenero.getSelectionModel().getSelectedItem().toString());
            //estadoCivil
            ps.setString(7, comboEstadoCivil.getSelectionModel().getSelectedItem().toString());
            //cep
            ps.setString(8, txtCep.getText());
            //logradouro
            ps.setString(9, txtLogradouro.getText());
            //numero,
            ps.setString(10, txtNumero.getText());
            //complemento
            ps.setString(11, txtComplemento.getText());
            //bairro
            ps.setString(12, txtBairro.getText());
            //cidade
            ps.setString(13, txtCidade.getText());
            //estado
            ps.setString(14, txtEstado.getText());
            //telPricipal
            ps.setString(15, txtTelPrincipal.getText());
            //telSecundario
            ps.setString(16, txtTelSecundario.getText());
            //email
            ps.setString(17, txtEmail.getText());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
   
    }
    }
}
