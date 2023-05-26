<%--
  Created by IntelliJ IDEA.
  User: Maitane
  Date: 09/03/2023
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%> <!--JSP-a zuzenean deitzen bada, gonbidatu saioa ez sartu-->
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% HttpSession session = request.getSession(false);
    if(session==null){%>
        <a href="/websistemak2023/jsp/login_form.jsp">Log in</a>
    <% }else{
        String username = (String) session.getAttribute("ussername"); %>
        <h3> ONGI ETORRI, <%=username%></h3>
        <a href="/websistemak2023/servlet/Main">Reload MainServlet</a>
        <br/>
        <a href="/websistemak2023/jsp/welcome.jsp"> Reload Welcome</a>
        <br/><br/>
        <a href="/websistemak2023/servlet/Main?logout=true">Log Out</a>
    <%}%>
</body>
</html>
