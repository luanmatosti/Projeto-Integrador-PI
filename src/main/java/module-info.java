module com.mycompany.projetointegrador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.projetointegrador to javafx.fxml;
    exports com.mycompany.projetointegrador;
}
