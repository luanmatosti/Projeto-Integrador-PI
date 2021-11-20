/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetointegrador;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    @FXML
    private Button buttonConsultar;

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
    private void editar(ActionEvent event) throws IOException {
        LinhaTabelaCliente linha = tableCliente.getSelectionModel().getSelectedItem();
        if (linha != null) {
            int id = linha.getId();
            App.abrirTelaCliente(id);
        }
    }

    @FXML
    private void apagar(ActionEvent event) {
        LinhaTabelaCliente linha = tableCliente.getSelectionModel().getSelectedItem();

        if (linha != null) {

            int id = linha.getId();
            String sql = "DELETE FROM cliente WHERE id = ?";
            try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
                ps.setInt(1, id);

                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void limpar(ActionEvent event) {
        txtCpf.clear();
        tableCliente.getItems().clear();

    }

    @FXML
    private void consultar(ActionEvent event) {
        if (txtCpf.getText().isBlank()) {
            atualizarTabela();
        } else {
            pesquisarCpf();
        }
    }

    private void atualizarTabela() {
        tableCliente.getItems().clear();

        String sql = "SELECT * FROM cliente";
        try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String telPrincipal = rs.getString("telPrincipal");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");

                LinhaTabelaCliente linha = new LinhaTabelaCliente(id, nome, sobrenome, telPrincipal, email, cpf);
                tableCliente.getItems().add(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pesquisarCpf() {
        tableCliente.getItems().clear();
        String sql = "SELECT * FROM cliente WHERE cpf like ?";

        try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
            ps.setString(1, "%" + txtCpf.getText() + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LinhaTabelaCliente linha = new LinhaTabelaCliente(rs.getInt("id"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("telPrincipal"),
                        rs.getString("email"), rs.getString("cpf"));
                tableCliente.getItems().add(linha);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void tratarCaixaPesquisar(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
        pesquisarCpf();
        }
    }
}
