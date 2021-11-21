package com.mycompany.projetointegrador;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class RelatorioController implements Initializable {

    @FXML
    private TableView<LinhaTabelaRelatorio> tableRelatorio;
    @FXML
    private TableColumn<LinhaTabelaRelatorio, String> colunaCliente;
    @FXML
    private TableColumn<LinhaTabelaRelatorio, Integer> colunaCodVenda;
    @FXML
    private TableColumn<LinhaTabelaRelatorio, LocalDate> colunaData;
    @FXML
    private TableColumn<LinhaTabelaRelatorio, String> colunaProduto;
    @FXML
    private TableColumn<LinhaTabelaRelatorio, Integer> colunaQtd;
    @FXML
    private TableColumn<LinhaTabelaRelatorio, Double> colunaTotal;
    @FXML
    private DatePicker dtDe;
    @FXML
    private DatePicker dtAte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     colunaCliente.setCellValueFactory(new PropertyValueFactory("cliente"));
     colunaCodVenda.setCellValueFactory(new PropertyValueFactory("codVenda"));
     colunaData.setCellValueFactory(new PropertyValueFactory("data"));   
     colunaProduto.setCellValueFactory(new PropertyValueFactory("nomeProduto"));
     colunaQtd.setCellValueFactory(new PropertyValueFactory("qtd"));
     colunaTotal.setCellValueFactory(new PropertyValueFactory("total"));
     
     LinhaTabelaRelatorio ltr = new LinhaTabelaRelatorio("Leonardo", 50, LocalDate.now() , "O Pequeno Príncipe", 30, 50.00);
        
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        /*verificar com Luan
        if (txt.getText().isBlank()) {
            atualizarTabela();
        } else {
            pesquisarCpf();*/
    }

}
