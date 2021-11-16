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
    private TableColumn<LinhaTabelaProduto, String> colunaCategoria;
    @FXML
    private TableColumn<LinhaTabelaProduto, Double> colunaPreco;
    @FXML
    private TableColumn<LinhaTabelaProduto, Integer> colunaEstoque;
    @FXML
    private TextField txtPesquisa;
    @FXML
    private TableColumn<LinhaTabelaProduto, Integer> colunaId;

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

            int id = linha.getId();
            String sql = "DELETE FROM produto WHERE id = ?";
            try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
                ps.setInt(1, id);

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
                Integer id = rs.getInt("id");
                String autor = rs.getString("autor");
                String titulo = rs.getString("titulo");
                String categoria = rs.getString("categoria");
                Double preco = rs.getDouble("preco");
                Integer qtd = rs.getInt("qtd");

                LinhaTabelaProduto linha = new LinhaTabelaProduto(id,titulo, autor, categoria, preco, qtd);
                tableProduto.getItems().add(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
