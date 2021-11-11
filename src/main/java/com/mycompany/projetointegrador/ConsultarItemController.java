/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetointegrador;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class ConsultarItemController implements Initializable {

    @FXML
    private TableView<LinhaTabelaProduto> tableProduto;
    @FXML
    private TableColumn<LinhaTabelaProduto, String> colunaTituto;
    @FXML
    private TableColumn<LinhaTabelaProduto, String> colunaAutor;
    @FXML
    private TableColumn<LinhaTabelaProduto, String> colunaAssunto;
    @FXML
    private TableColumn<LinhaTabelaProduto, Double> colunaPreco;
    @FXML
    private TableColumn<LinhaTabelaProduto, Integer> colunaEstoque;
    @FXML
    private TextField txtPesquisa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaTituto.setCellValueFactory(new PropertyValueFactory("titulo"));
        colunaAutor.setCellValueFactory(new PropertyValueFactory("autor"));
        colunaAssunto.setCellValueFactory(new PropertyValueFactory("assunto"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        colunaEstoque.setCellValueFactory(new PropertyValueFactory("estoque"));

        //LinhaTabelaProduto linha = new LinhaTabelaProduto ("1984","George Orwell","Suspense",49.50, 15);
        //tableProduto.getItems().add(linha);
    }

    @FXML
    private void limpar(ActionEvent event) {
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        atualizarTabela();
    }

    @FXML
    private void alterar(ActionEvent event) {
    }

    @FXML
    private void deletar(ActionEvent event) {
        LinhaTabelaProduto linha = tableProduto.getSelectionModel().getSelectedItem();

        if (linha != null) {

            String autor = linha.getAutor();
            String sql = "DELETE FROM produto WHERE autor = ?";
            try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
                ps.setString(1, autor);

                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizarTabela() {
        tableProduto.getItems().clear();

        String sql = "SELECT * FROM produto";
        try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String autor = rs.getString("autor");
                String titulo = rs.getString("titulo");
                String assunto = rs.getString("genero");
                Double preco = rs.getDouble("preco");
                Integer estoque = rs.getInt("estoque");

                LinhaTabelaProduto linha = new LinhaTabelaProduto(titulo, autor, assunto, preco, estoque);
                tableProduto.getItems().add(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
