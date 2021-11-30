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

    public static Integer idEdicao = null;
    private boolean estaEditando = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboCategoria.getItems().add("Romance");
        comboCategoria.getItems().add("Drama");
        comboCategoria.getItems().add("Novela");
        comboCategoria.getItems().add("Conto");
        comboCategoria.getItems().add("Crônica");
        comboCategoria.getItems().add("Poesia");
        comboCategoria.getItems().add("Biografia");
        comboCategoria.getItems().add("Ficção");
        comboCategoria.getItems().add("Aventura");
        comboCategoria.getItems().add("História em Quadrinhos");
        comboCategoria.getItems().add("Literatura");
        comboCategoria.getItems().add("Terror");

        if (idEdicao != null) {
            String sql = "SELECT * FROM produto WHERE id = ?";

            try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
                ps.setInt(1, idEdicao);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    txtAutor.setText(rs.getString("autor"));
                    txtTitulo.setText(rs.getString("titulo"));
                    txtEditora.setText(rs.getString("editora"));
                    dtPublicacao.setValue(rs.getDate("dtPublicacao").toLocalDate());
                    txtPagina.setText(String.valueOf(rs.getInt("nmrPagina")));
                    comboCategoria.setValue(rs.getString("categoria"));
                    txtPreco.setText(String.valueOf(rs.getDouble("preco")));
                    txtQtd.setText(String.valueOf(rs.getInt("qtd")));

                    estaEditando = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void limpar(ActionEvent event) {
        txtAutor.clear();
        txtTitulo.clear();
        txtEditora.clear();
        dtPublicacao.setValue(null);
        txtPagina.clear();
        comboCategoria.getSelectionModel().clearSelection();
        txtPreco.clear();
        txtQtd.clear();
    }

    @FXML
    private void cadastrar(ActionEvent event) {
        if (!estaEditando) {
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
                limparTela();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String sql = "UPDATE produto SET autor = ?, titulo = ?, editora = ?, dtPublicacao = ?, nmrPagina = ?, categoria = ?, preco = ?, qtd = ? WHERE id = ?";

            try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
                ps.setString(1, txtAutor.getText());
                ps.setString(2, txtTitulo.getText());
                ps.setString(3, txtEditora.getText());
                ps.setDate(4, Date.valueOf(dtPublicacao.getValue()));
                ps.setInt(5, Integer.parseInt(txtPagina.getText()));
                ps.setString(6, comboCategoria.getSelectionModel().getSelectedItem().toString());
                ps.setDouble(7, Double.parseDouble(txtPreco.getText()));
                ps.setInt(8, Integer.parseInt(txtQtd.getText()));
                ps.setInt(9, idEdicao);

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
        txtAutor.clear();
        txtTitulo.clear();
        txtEditora.clear();
        dtPublicacao.setValue(null);
        txtPagina.clear();
        comboCategoria.getSelectionModel().clearSelection();
        txtPreco.clear();
        txtQtd.clear();
    }
}
