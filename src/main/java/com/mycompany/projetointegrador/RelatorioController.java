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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author lmato
 */
public class RelatorioController implements Initializable {

    @FXML
    private TableView<?> tableRelatorio;
    @FXML
    private TableColumn<?, ?> colunaCliente;
    @FXML
    private TableColumn<?, ?> colunaCodVenda;
    @FXML
    private TableColumn<?, ?> colunaData;
    @FXML
    private TableColumn<?, ?> colunaProduto;
    @FXML
    private TableColumn<?, ?> colunaQtd;
    @FXML
    private TableColumn<?, ?> colunaTotal;
    @FXML
    private DatePicker dtDe;
    @FXML
    private DatePicker dtAte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void pesquisar(ActionEvent event) {
    }

}
