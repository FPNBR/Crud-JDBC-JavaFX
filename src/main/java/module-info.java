module com.fpnbr.crudjdbcjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fpnbr.crudjdbcjavafx to javafx.fxml;
    exports com.fpnbr.crudjdbcjavafx;
}