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
import javafx.scene.control.Alert;
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
public class ConsultarItemController implements Initializable {

    @FXML
    private TableView<LinhaTabelaProduto> tableProduto;
    @FXML
    private TableColumn<LinhaTabelaProduto, String> colunaTituto;
    @FXML
    private TableColumn<LinhaTabelaProduto, String> colunaAutor;
    @FXML
    private TableColumn<LinhaTabelaProduto, String> colunaCategoria;
    @FXML
    private TableColumn<LinhaTabelaProduto, Double> colunaPreco;
    @FXML
    private TableColumn<LinhaTabelaProduto, Integer> colunaEstoque;
    @FXML
    private TextField txtPesquisa;
    @FXML
    private TableColumn<LinhaTabelaProduto, Integer> colunaId;
    @FXML
    private Button buttonPesquisar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaId.setCellValueFactory(new PropertyValueFactory("id"));
        colunaTituto.setCellValueFactory(new PropertyValueFactory("titulo"));
        colunaAutor.setCellValueFactory(new PropertyValueFactory("autor"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        colunaEstoque.setCellValueFactory(new PropertyValueFactory("quantidade"));

        //LinhaTabelaProduto linha = new LinhaTabelaProduto ("50 tons","George","Amor",158.80, 68);
        //tableProduto.getItems().add(linha);
    }

    @FXML
    private void limpar(ActionEvent event) {
        txtPesquisa.clear();
        tableProduto.getItems().clear();
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        if (txtPesquisa.getText().isBlank()) {
            atualizarTabela();
        } else {
            pesquisarTitulo();
        }
    }

    @FXML
    private void alterar(ActionEvent event) throws IOException {
        LinhaTabelaProduto linha = tableProduto.getSelectionModel().getSelectedItem();
        if (linha != null) {
            int id = linha.getId();
            App.abrirTelaItem(id);
        }
    }

    @FXML
    private void deletar(ActionEvent event) {
        if (App.perguntar("Excluir? ", "Confirma exclus??o?", "A opera????o n??o poder?? ser desfeita")) {
            LinhaTabelaProduto linha = tableProduto.getSelectionModel().getSelectedItem();

            if (linha != null) {

                int id = linha.getId();
                String sql = "DELETE FROM produto WHERE id = ?";
                try (PreparedStatement ps = db.connect().prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.execute();
                    atualizarTabela();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Produto n??o pode ser deletado, pois j?? est?? relacionado a um pedido");
                    alert.showAndWait();
                }

            }

        }
    }

    private void atualizarTabela() {
        tableProduto.getItems().clear();

        String sql = "SELECT * FROM produto";
        try (PreparedStatement ps = db.connect().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String autor = rs.getString("autor");
                String titulo = rs.getString("titulo");
                String categoria = rs.getString("categoria");
                Double preco = rs.getDouble("preco");
                Integer qtd = rs.getInt("qtd");

                LinhaTabelaProduto linha = new LinhaTabelaProduto(id, titulo, autor, categoria, preco, qtd);
                tableProduto.getItems().add(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pesquisarTitulo() {
        tableProduto.getItems().clear();
        String sql = "SELECT * FROM produto WHERE titulo like ?";

        try (PreparedStatement ps = db.connect().prepareStatement(sql)) {
            ps.setString(1, "%" + txtPesquisa.getText() + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LinhaTabelaProduto linha = new LinhaTabelaProduto(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("categoria"),
                        rs.getDouble("preco"), rs.getInt("qtd"));
                tableProduto.getItems().add(linha);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void tratarCaixaPesquisar(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pesquisarTitulo();
        }
    }
}
