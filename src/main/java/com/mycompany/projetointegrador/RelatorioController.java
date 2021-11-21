package com.mycompany.projetointegrador;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        /*verificar com Luan (conflito RelatorioController e LinhaTabelaRelatorio)*/
String sql = "SELECT cliente.nome, pedido.idPedido,produto.id, produto.preco,"
+ "pedido.dataPedido FROM pedido "
+ "INNER JOIN cliente ON pedido.idcliente = cliente.id "
+ "INNER JOIN itemPedido ON pedido.idPedido = itemPedido.idPedido "
+ "INNER JOIN produto ON itemPedido.idProduto = produto.id ";

//Verificar Luan (por Leonardo)
/*try(PreparedStatement ps= db.connect().prepareStatement(sql)){
ps.setDate(1, Date.valueOf(dtDe.getValue()));
ps.setDate(2, Date.valueOf(dtAte.getValue()));

ResultSet rs = ps.executeQuery();


while (rs.next()){
    LinhaTabelaRelatorio ltr = new LinhaTabelaRelatorio(
            rs.getString("nome"),
            rs.getInt("idPedido"),
            rs.getInt("id"),
            rs.getDouble("preco"),
            rs.getDate("dataPedido").toLocalDate()
    );
    
    tableRelatorio.getItems().add(ltr);
    tableRelatorio.refresh();
}
 
}
catch(Exception e){
    e.printStackTrace();
}*/
    }
}

