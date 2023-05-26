<%--
  Created by IntelliJ IDEA.
  User: Maitane
  Date: 03/03/2023
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String mezua = (String) request.getAttribute("katea");
    if(mezua!=null){%>
        <h1><%=mezua%></h1>
    <%} else{ %>
        <p> JSP-a zuzenean deitu duzu. Ez da atributua kargatu.</p>
    <% } %>
</body>
</html>
