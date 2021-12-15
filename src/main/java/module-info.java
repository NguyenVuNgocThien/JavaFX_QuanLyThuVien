module com.mycompany.qltv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    requires java.base;
    opens com.mycompany.qltv to javafx.fxml;
    exports com.mycompany.qltv;
    exports DTO;
    exports DAO;
    exports Response;
}
