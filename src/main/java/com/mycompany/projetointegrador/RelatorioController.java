package com.mycompany.projetointegrador;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     colunaCliente.setCellValueFactory(new PropertyValueFactory("cliente"));
     colunaCodVenda.setCellValueFactory(new PropertyValueFactory("CodVenda"));
     colunaData.setCellValueFactory(new PropertyValueFactory("Data"));   
     colunaProduto.setCellValueFactory(new PropertyValueFactory("Produto"));
     colunaQtd.setCellValueFactory(new PropertyValueFactory("Qtd"));
     colunaTotal.setCellValueFactory(new PropertyValueFactory("Total"));
     
     //LinhaTabelaRelatorio ltr = new LinhaTabelaRelatorio("Leonardo", 50, LocalDate.now() , "O Pequeno Príncipe", 30, 50.00);
     //tableRelatorio.getItems().add(ltr);
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        long dias = DAYS.between(dtDe.getValue(), dtAte.getValue().plusDays(1));
        
        if (dias < 0 || dias > 31){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("A Data Inicial não pode ser maior do que a Data Final, "
                    + "e o período do relatório não pode exceder 30 dias.");
            alert.showAndWait();
            return;
        }
        tableRelatorio.getItems().clear();
        
        /*verificar com Luan (conflito RelatorioController e LinhaTabelaRelatorio)*/
String sql = "SELECT cliente.nome, pedido.idPedido, produto.titulo, precoProduto, pedido.dataPedido  from pedido "
      +"INNER JOIN cliente ON pedido.idCliente = cliente.id "
      +"INNER JOIN itemPedido ON pedido.idPedido= itemPedido.idPedido "
      +"INNER JOIN produto ON itemPedido.idPedido = produto.id ";
      //+"WHERE pedido.dataPedido > ? AND pedido.dataPedido < ? ";

//Verificar Luan (por Leonardo)
try(PreparedStatement ps= db.connect().prepareStatement(sql)){
ps.setDate(1, Date.valueOf(dtDe.getValue()));
ps.setDate(2, Date.valueOf(dtAte.getValue()));

ResultSet rs = ps.executeQuery();


while (rs.next()){
    LinhaTabelaRelatorio ltr = new LinhaTabelaRelatorio(
           /*rs.getString("nome"),
            rs.getInt("idPedido"),
            rs.getInt("id"),
            rs.getDouble("preco"),
            rs.getDate("dataPedido").toLocalDate()*/
            
rs.getString("nome"),
rs.getInt("idPedido"),
rs.getDate("dataPedido").toLocalDate(),
rs.getString("titulo"),
rs.getInt("qtd"),
rs.getDouble("preco")
    );
    
    tableRelatorio.getItems().add(ltr);
    tableRelatorio.refresh();
}
 
}
catch(Exception e){
    e.printStackTrace();
}
    }

}
