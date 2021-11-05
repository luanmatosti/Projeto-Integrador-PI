package com.mycompany.projetointegrador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
        stage.setMinWidth(700);
        stage.setMinHeight(455);
        stage.setTitle("Livraria Saber");
        stage.getIcons().add(new Image("/com/mycompany/projetointegrador/imagens/iconelivropagina.png"));
        stage.show();
    }

    static void setRoot(String fxml, BorderPane container) throws IOException {
        container.setCenter(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}   