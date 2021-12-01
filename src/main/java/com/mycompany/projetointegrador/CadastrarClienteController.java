/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetointegrador;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    public static Integer idEdicao = null;
    private boolean estaEditando = false;

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

        if (idEdicao != null) {
            String sql = "SELECT * FROM cliente WHERE id = ?";

            try (PreparedStatement ps = db.connect().prepareStatement(sql)) {
                ps.setInt(1, idEdicao);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    txtNome.setText(rs.getString("nome"));
                    txtSobrenome.setText(rs.getString("sobrenome"));
                    dtNascimento.setValue(rs.getDate("dtNascimento").toLocalDate());
                    txtRg.setText(rs.getString("rg"));
                    txtCpf.setText(rs.getString("cpf"));
                    comboGenero.setValue(rs.getString("genero"));
                    comboEstadoCivil.setValue(rs.getString("estadoCivil"));
                    txtCep.setText(rs.getString("cep"));
                    txtLogradouro.setText(rs.getString("logradouro"));
                    txtNumero.setText(rs.getString("numero"));
                    txtComplemento.setText(rs.getString("complemento"));
                    txtBairro.setText(rs.getString("bairro"));
                    txtCidade.setText(rs.getString("cidade"));
                    txtEstado.setText(rs.getString("estado"));
                    txtTelPrincipal.setText(rs.getString("telPrincipal"));
                    txtTelSecundario.setText(rs.getString("telSecundario"));
                    txtEmail.setText(rs.getString("email"));

                    estaEditando = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
        if (txtNome.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Nome obrigatório.");
            alert.showAndWait();
            return;
        }
        
        if (!Pattern.compile("^[A-Za-z ]+$").matcher(txtNome.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Nome inválido.");
            alert.showAndWait();
            return;
        }
        
        if (txtSobrenome.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sobrenome obrigatório.");
            alert.showAndWait();
            return;
        }
        
        if (!Pattern.compile("^[A-Za-z ]+$").matcher(txtSobrenome.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sobrenome inválido.");
            alert.showAndWait();
            return;
        }
                
        if (txtRg.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("RG obrigatório.");
            alert.showAndWait();
            return;
        }        
        
        
        if (txtCpf.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("CPF obrigatório.");
            alert.showAndWait();
            return;
        }
        
        if (!Pattern.compile("^\\d{11}$").matcher(txtCpf.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("CPF inválido.");
            alert.showAndWait();
            return;
        }
        
        if (comboGenero.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Gênero obrigatório.");
            alert.showAndWait();
            return;
        }
         if (comboEstadoCivil.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Estado Civil obrigatório..");
            alert.showAndWait();
            return;
        }
        
        if (txtCep.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("CEP obrigatório.");
            alert.showAndWait();
            return;
        }
        
        if (!Pattern.compile("^\\d{8}$").matcher(txtCep.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("CEP inválido.");
            alert.showAndWait();
            return;
        }
        
        if (txtLogradouro.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Logradouro obrigatório.");
            alert.showAndWait();
            return;
        }
        
        if (!Pattern.compile("^[A-Za-z ]+$").matcher(txtLogradouro.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Logradouro inválido");
            alert.showAndWait();
            return;
        }
        
        if (txtNumero.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Número obrigatório.");
            alert.showAndWait();
            return;
        }
         if (!Pattern.compile("^[0-9]+$").matcher(txtNumero.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Número inválido.");
            alert.showAndWait();
            return;
        }
        
        
        if (txtComplemento.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Complemento obrigatório.");
            alert.showAndWait();
            return;
        }
        
        if (txtBairro.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Bairro obrigatório.");
            alert.showAndWait();
            return;
        }
        
        
        if (txtCidade.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Cidade obrigatório.");
            alert.showAndWait();
            return;
        }
        
        if (txtEstado.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Estado obrigatório");
            alert.showAndWait();
            return;
        }
        
        if (txtTelPrincipal.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Telefone Principal obrigatório");
            alert.showAndWait();
            return;
        }
        
        if (!Pattern.compile("^\\d{11}$").matcher(txtTelPrincipal.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Telefone Principal inválido");
            alert.showAndWait();
            return;
        }
        
        if (txtTelSecundario.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Telefone Secundário obrigatório");
            alert.showAndWait();
            return;
        }
        
        if (!Pattern.compile("^\\d{11}$").matcher(txtTelSecundario.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Telefone Secundário inválido");
            alert.showAndWait();
            return;
        }
        
        if (txtEmail.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Email obrigatório");
            alert.showAndWait();
            return;
        }
        
              
        
        
        if (!estaEditando) {
            String sql = "INSERT INTO cliente (nome,sobrenome,dtNascimento,rg,cpf,genero,estadoCivil,cep,logradouro,numero,complemento,bairro,cidade,estado,telPrincipal,telSecundario,email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement ps = db.connect().prepareStatement(sql)) {

                ps.setString(1, txtNome.getText());
                ps.setString(2, txtSobrenome.getText());
                ps.setDate(3, Date.valueOf(dtNascimento.getValue()));
                ps.setString(4, txtRg.getText());
                ps.setString(5, txtCpf.getText());
                ps.setString(6, comboGenero.getSelectionModel().getSelectedItem().toString());
                ps.setString(7, comboEstadoCivil.getSelectionModel().getSelectedItem().toString());
                ps.setString(8, txtCep.getText());
                ps.setString(9, txtLogradouro.getText());
                ps.setString(10, txtNumero.getText());
                ps.setString(11, txtComplemento.getText());
                ps.setString(12, txtBairro.getText());
                ps.setString(13, txtCidade.getText());
                ps.setString(14, txtEstado.getText());
                ps.setString(15, txtTelPrincipal.getText());
                ps.setString(16, txtTelSecundario.getText());
                ps.setString(17, txtEmail.getText());

                ps.execute();
                limparTela();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String sql = "UPDATE cliente SET nome = ?,sobrenome = ?,dtNascimento = ?,rg = ?,cpf = ?,genero = ?,estadoCivil = ?,cep = ?,logradouro = ?,numero = ?,complemento = ?,bairro = ?,cidade = ?,estado = ?,telPrincipal = ?,telSecundario = ?,email = ? WHERE id = ?";

            try (PreparedStatement ps = db.connect().prepareStatement(sql)) {
                ps.setString(1, txtNome.getText());
                ps.setString(2, txtSobrenome.getText());
                ps.setDate(3, Date.valueOf(dtNascimento.getValue()));
                ps.setString(4, txtRg.getText());
                ps.setString(5, txtCpf.getText());
                ps.setString(6, comboGenero.getSelectionModel().getSelectedItem().toString());
                ps.setString(7, comboEstadoCivil.getSelectionModel().getSelectedItem().toString());
                ps.setString(8, txtCep.getText());
                ps.setString(9, txtLogradouro.getText());
                ps.setString(10, txtNumero.getText());
                ps.setString(11, txtComplemento.getText());
                ps.setString(12, txtBairro.getText());
                ps.setString(13, txtCidade.getText());
                ps.setString(14, txtEstado.getText());
                ps.setString(15, txtTelPrincipal.getText());
                ps.setString(16, txtTelSecundario.getText());
                ps.setString(17, txtEmail.getText());
                ps.setInt(18, idEdicao);

                ps.execute();
                limparTela();

                estaEditando = false;
                idEdicao = null;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void limparTela() {
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
}
