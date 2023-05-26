<%--
  Created by IntelliJ IDEA.
  User: Maitane
  Date: 07/03/2023
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%> <!--Defektuzko sesioa irekitzea ekidin-->
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#87ceeb">
    <h3>Sartu zure erabiltzailea eta pasahitza:</h3>
    <form method="POST" action="/websistemak2023/servlet/LoginJSP">
        <input name="username" type="text" placeholder="Erabiltzailea..."/>
        <input name="password" type="password" placeholder="Pasahitza...">
        <input type="submit"/>
    </form>
    <% Object log_out_aux =request.getAttribute("log_out");
    String ondo = (String) request.getAttribute("txarto");
        if(ondo!=null){%>
            <p> <%=ondo%> </p>
        <% } else if (log_out_aux!=null){
            if((boolean) log_out_aux){%>
                <h5>LOG OUT!!!</h5>
        <%}
        }%>
</body>
</html>
