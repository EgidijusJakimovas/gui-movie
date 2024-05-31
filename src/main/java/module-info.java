module org.example.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    opens org.example.gui to javafx.fxml;
    exports org.example.gui;
    exports org.example.gui.controller;
    opens org.example.gui.controller to javafx.fxml;
    opens org.example.gui.model to javafx.base;

}
