<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: frede
  Date: 22-02-2020
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adminbr</title>
</head>
<body>

Her kan du se listen af brugere. Du kan også slette brugere her.
<br>
<br>

${requestScope.besked}

<form action="AdminServlet" method="post">
    <label for="fname">Slet bruger:</label><br>
    <input type="text" id="fname" name="Navn"><br>
    <input type="submit" value="Slet">
</form>

<c:forEach var="element" items="${applicationScope.brugerMap}">

    ${element.key}
    <br>
</c:forEach>


    </body>
</html>
