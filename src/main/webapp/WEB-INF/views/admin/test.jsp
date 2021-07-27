<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 26.07.2021
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Secured Site
<sec:authorize access="isAuthenticated()">
  <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
  <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>
</body>
</html>
