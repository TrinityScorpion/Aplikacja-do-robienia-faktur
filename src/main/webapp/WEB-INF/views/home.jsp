<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 11.07.2021
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Dzień Dobry z widoku

<h2><spring:message code="home.welcome"/></h2>
<table border="1">
    <tr>
        <td>Invoice ID</td>
        <td>Created</td>
        <td>Deadline</td>
        <td>Invoice Number</td>

    </tr>
    <c:forEach items="${invoiceList}" var="invoice">
        <tr>
            <td>${invoice.id}</td>
            <td>${invoice.created}</td>
            <td>${invoice.deadline}</td>
            <td>${invoice.invoice_number}</td>
            <td><a href="/book/delete/validation/${book.id}">Delete</a><a href="/form/book/edit/${book.id}">Edit</a></td>
                <%--            <td><a href="/book/delete/${book.id}">Delete</a><a href="/form/book/edit/${book.id}">Edit</a></td>--%>
        </tr>

    </c:forEach>
</table>

</body>
</html>
