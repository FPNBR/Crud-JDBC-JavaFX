package com.fpnbr.crudjdbcjavafx.models.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoJdbcDAO {

    private static String url = "jdbc:postgresql://localhost:5432/crudjdbcjavafx";
    private static String user = "postgres";
    private static String password = "admin";
    private static Connection connection = null;

    static {
        conectar();
    }

    public ConexaoJdbcDAO() {
        conectar();
    }

    private static void conectar () {
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
                System.out.println("Banco conectado com sucesso");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}