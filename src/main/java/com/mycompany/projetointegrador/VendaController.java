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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author lmato
 */
public class VendaController implements Initializable {

    @FXML
    private TableView<LinhaTabelaVenda> tableVenda;
    @FXML
    private TableColumn<LinhaTabelaVenda, Integer> colunaCodigo;
    @FXML
    private TableColumn<LinhaTabelaVenda, String> colunaProduto;
    @FXML
    private TableColumn<LinhaTabelaVenda, Integer> colunaQtd;
    @FXML
    private TableColumn<LinhaTabelaVenda, Float> colunaValor;
    @FXML
    private TextField editProduto;
    @FXML
    private TextField editQtdProduto;
    @FXML
    private TextField editCpf;
    @FXML
    private DatePicker dataPedido;
    @FXML
    private TextField totalPedido;
    @FXML
    private Label labelCliente;

    private Integer idCliente = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        colunaCodigo.setCellValueFactory(new PropertyValueFactory("colunaCodigo"));
        colunaProduto.setCellValueFactory(new PropertyValueFactory("colunaProduto"));
        colunaQtd.setCellValueFactory(new PropertyValueFactory("colunaQtd"));
        colunaValor.setCellValueFactory(new PropertyValueFactory("colunaValor"));
        //LinhaTabelaVenda ltv = new LinhaTabelaVenda(1,"1984",1,1);
        //tableVenda.getItems().add(ltv);
    }

    @FXML
    private void finalizarPedido(ActionEvent event) {
        String sqlPedido = "INSERT INTO pedido VALUES (?,?)";

        try ( PreparedStatement ps = db.connect().prepareStatement(sqlPedido, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, Date.valueOf(dataPedido.getValue()));

            ps.setInt(2, idCliente);

            ps.execute();

            ResultSet rsKeys = ps.getGeneratedKeys();
            if (rsKeys.next()) {
                int idPedido = rsKeys.getInt(1);
                registrarItensPedido(idPedido);
                decrementarEstoque();
                cancelarPedido(event);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("Pedido Realizado");
                alert.showAndWait();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //inserir itens na tabela explosão ItemPedido
    private void registrarItensPedido(int idPedido) {
        for (int i = 0; i < tableVenda.getItems().size(); i++) {
            String sql = "INSERT INTO itemPedido (idPedido,idProduto, qtd, precoProduto) VALUES (?,?,?,?)";

            try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
                ps.setInt(1, idPedido);
                ps.setInt(2, tableVenda.getItems().get(i).getColunaCodigo());
                ps.setInt(3, tableVenda.getItems().get(i).getColunaQtd());
                ps.setFloat(4, tableVenda.getItems().get(i).getColunaValor());

                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

   private void decrementarEstoque() {
        //qtdatual - informado
        for (int i = 0; i < tableVenda.getItems().size(); i++) {
            String sql = "UPDATE produto SET qtd = (qtd - ?) WHERE id = ?";
            try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
                ps.setInt(1, tableVenda.getItems().get(i).getColunaQtd());
                ps.setInt(2, tableVenda.getItems().get(i).getColunaCodigo());

                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    
    @FXML
    private void removerProduto(ActionEvent event) {
        if (tableVenda.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        tableVenda.getItems().remove(tableVenda.getSelectionModel().getSelectedIndex());

    }

    @FXML
    private void cancelarPedido(ActionEvent event) {
        editCpf.clear();
        labelCliente.setText("Nome Cliente");
        colunaCodigo = null;
        colunaProduto = null;
        colunaQtd = null;
        colunaValor = null;
        tableVenda.getItems().clear();
        dataPedido.setValue(null);

    }

    @FXML
    private void procurarCliente(ActionEvent event) {
        String sql = "SELECT TOP 1 * FROM cliente WHERE  cpf = ?";

        try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
            ps.setString(1, editCpf.getText());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("Nome");
                labelCliente.setText(nome);

                idCliente = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void adicionarProduto(ActionEvent event) {
        if (editProduto.getText().isBlank() && editQtdProduto.getText().isBlank()) {
            return;
        }

        String sql = "SELECT TOP 1 * FROM produto WHERE id = ?";

        try ( PreparedStatement ps = db.connect().prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(editProduto.getText()));

            ResultSet rs = ps.executeQuery();
            float total = 0;
            
            if (rs.next()) {
                LinhaTabelaVenda ltv = new LinhaTabelaVenda(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        Integer.parseInt(editQtdProduto.getText()),
                        rs.getFloat("preco"));
                
                total += rs.getFloat("preco");
                tableVenda.getItems().add(ltv);
                totalPedido.setText(String.valueOf(total));
                editProduto.clear();
                editQtdProduto.clear();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mudarQtdProduto(ActionEvent event) {
        if (tableVenda.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        LinhaTabelaVenda ltv = tableVenda.getSelectionModel().getSelectedItem();
        ltv.setColunaQtd(Integer.parseInt(editQtdProduto.getText()));
        tableVenda.refresh();
    }
}
