package edu.odeyalko.servlets.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveUserToDB {
    private User user;
    private Connection connection;

    public SaveUserToDB(User user) {
        this.user = user;
    }

    public SaveUserToDB() {
    }

    public Connection connect() {
        Connection conn = null;
        String url = "jdbc:postgresql://localhost/";
        String user = "postgres";
        String password = "password";
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            this.connection = conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean saveUser() {
        return saveUser0();
    }

    public boolean saveUser(User user) {
        this.user = user;
        return saveUser0();
    }

    private boolean saveUser0() {
        connect();
        String command = "INSERT INTO users(name, password) VALUES (?, ?)";
        try {
            final PreparedStatement prepared = this.connection.prepareStatement(command);
            prepared.setString(1, this.user.getName());
            prepared.setString(2, this.user.getPassword());
            prepared.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
