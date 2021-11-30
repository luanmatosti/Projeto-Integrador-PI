package com.mycompany.projetointegrador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("TelaPrincipal"), 700, 455);
        stage.setScene(scene);
        stage.setMinWidth(727);
        stage.setMinHeight(455);
        stage.setTitle("Livraria Saber");
        stage.getIcons().add(new Image("/com/mycompany/projetointegrador/imagens/iconelivropagina.png"));
        stage.show();
    }

    //teste felipe reis, Lucas de Santana Schmalz
    static void setRoot(String fxml, BorderPane container) throws IOException {
        container.setCenter(loadFXML(fxml));
    }

    static void abrirTelaCliente(int id) throws IOException {
        CadastrarClienteController.idEdicao = id;
        BorderPane container = (BorderPane) scene.lookup("#container");
        container.setCenter(loadFXML("CadastrarCliente"));
    }

    static void abrirTelaItem(int id) throws IOException {
        CadastrarItemController.idEdicao = id;
        BorderPane container = (BorderPane) scene.lookup("#container");
        container.setCenter(loadFXML("CadastrarItem"));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static boolean perguntar(String titulo, String cabecalho, String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(msg);

        ButtonType buttonSim = new ButtonType("Sim");
        ButtonType buttonNao = new ButtonType("Não");

        alert.getButtonTypes().setAll(buttonSim, buttonNao);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonSim) {
            return true;
        } else {
            return false;
        }
    }
}
