module com.example.bateriaejerciciodos {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.bateriaejerciciodos to javafx.fxml;
    exports com.example.bateriaejerciciodos;
    exports com.example.bateriaejerciciodos.controllers;
    opens com.example.bateriaejerciciodos.controllers to javafx.fxml;
}