<%--
  Created by IntelliJ IDEA.
  User: frede
  Date: 22-02-2020
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opret bruger</title>
</head>
<body>

Her kan du registrer dig, som bruger på huskelisten.
<br>
<br>

${requestScope.besked}
<br>
<br>

<form action="OpretServlet" method="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="Navn"><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="lname" name="Kodeord"><br><br>
    <input type="submit" value="Opret">
</form>

</body>
</html>
