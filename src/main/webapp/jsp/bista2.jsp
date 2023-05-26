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
    <ul>
    <% String[] zerrenda = (String[]) request.getAttribute("arraya");
        if(zerrenda!=null){
            for(int i =0; i<zerrenda.length; i++){ %>

                <li><%=zerrenda[i]%></li>

           <% }
           }else{%>
                <p> JSP-a zuzenean deitu duzu. Ez da atributua kargatu.</p>
        <%}%>
    </ul>
</body>
</html>
