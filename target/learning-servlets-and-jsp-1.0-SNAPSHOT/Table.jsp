<%@ page import="edu.odeyalko.servlets.crudservlet.CrudOperationsDB" %>
<%@ page import="edu.odeyalko.servlets.crudservlet.Car" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: thepr_2iz2cnv
  Date: 05.07.2021
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
<%
    CrudOperationsDB operationsDB = new CrudOperationsDB();
    List<Car> select = operationsDB.select();

    for(Car car : select) {
        System.out.println(car.getName() +
                " " + car.getAge() +
                " " + car.getOwner());
    }
%>
</html>
