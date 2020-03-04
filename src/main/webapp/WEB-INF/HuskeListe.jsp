<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: frede
  Date: 22-02-2020
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HuskeListe</title>
</head>
<body>

${sessionScope.besked}

<h1>Du er nu klar til at tilføje vare til din indkøbskurv.</h1>

<form action="BuyServlet" method="post">
    <label for="fname">Skriv varer:</label><br>
    <input type="text" id="fname" name="VareNavn"><br>
    <input type="submit" value="Tilføj">
</form>

<br>
<br>

${requestScope.besked}

<br>
<br>
<c:forEach var="element" items="${sessionScope.basket}">

    ${element}
    <br>
</c:forEach>

<br>
<br>

<form action="LogOutServlet" method="post">
<%--    <label for="fname">Skriv varer:</label><br>--%>
<%--    <input type="text" id="fname" name="VareNavn"><br>--%>
    <input type="submit" value="Logout">
</form>

</body>
</html>
