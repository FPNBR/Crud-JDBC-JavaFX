module com.fpnbr.crudjdbcjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.fpnbr.crudjdbcjavafx to javafx.fxml;
    exports com.fpnbr.crudjdbcjavafx;
}