<%--
  Created by IntelliJ IDEA.
  User: frede
  Date: 22-02-2020
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Indkoebsliste</title>
</head>
<body>

<h1>Velkommen til din online indkøbsliste.</h1>
<br>
<br>

${requestScope.besked}
<br>

<form action="LoginServlet" method="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="Navn"><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="lname" name="Kodeord"><br><br>
    <input type="submit" value="Login">
</form>



</body>
</html>
