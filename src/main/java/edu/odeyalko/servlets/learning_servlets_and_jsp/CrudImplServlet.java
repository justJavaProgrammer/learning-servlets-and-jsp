package edu.odeyalko.servlets.learning_servlets_and_jsp;

import edu.odeyalko.servlets.crudservlet.Car;
import edu.odeyalko.servlets.crudservlet.CrudOperationsDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@WebServlet(name = "crud", value = "/crud")
public class CrudImplServlet extends HttpServlet {

    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String login = "postgres";
    private String password = "vfrcrhjc";


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("hello");
        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(url, login, password);
            CrudOperationsDB crud = new CrudOperationsDB(connection);
            final Car car = crud.selectOne(1);
            writer.write("<b> Hello");
            writer.write("<b> car: " + car.getName() + " " + car.getAge() + " " + car.getOwner());
            writer.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
