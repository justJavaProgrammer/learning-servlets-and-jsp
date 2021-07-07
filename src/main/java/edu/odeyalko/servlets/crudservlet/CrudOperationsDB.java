package edu.odeyalko.servlets.crudservlet;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudOperationsDB {
    private  Connection connection;
    private List<Car> list;

    public CrudOperationsDB(Connection connection) {
        this.connection = connection;
        this.list = new ArrayList<>();
    }

    public Connection getConnection() {
        return connection;
    }

    public List<Car> select() throws SQLException {
        String command = "SELECT * FROM car";
        Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery(command);
        while(resultSet.next()) {
            final String carName = resultSet.getString(1);
            final int age = resultSet.getInt(2);
            final String owner = resultSet.getString(3);
            this.list.add(new Car(carName, age, owner));
        }
        return list;
    }

    public Car selectOne(int id) throws SQLException {
        String command = "SELECT * FROM car WHERE id=(?)";
        PreparedStatement statement = connection.prepareStatement(command, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        statement.setInt(1, id);
        Car car = null;
        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.first()) {
            car = new Car(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3));
        }
        return car;
    }
}
