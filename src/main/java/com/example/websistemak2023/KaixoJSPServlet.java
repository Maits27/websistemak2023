package com.example.websistemak2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "KaixoJSPServlet", value = "/KaixoJSPServlet")
public class KaixoJSPServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException{
        message = "Kaixo, Mundua!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> KaixoJSPServlet ---> doGet() metodoan sartzen");

        //HTTP eskaera adierazten duen objektuan atributu bat gehitu atrubutu hori 'message' String delarik
        request.setAttribute("katea", message);

        // aplikazioaren fluxua servlet-etik JSP batera pasatuko dugu
        System.out.println("---> KaixoJSPServlet ---> /jsp/bista.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/bista.jsp");
        rd.forward(request, response); //pasatu kontrola jsp-ra baina servlet-a bere exekuzioa amaitzen du

        System.out.println("<--- KaixoJSPServlet <--- doGet() metodotik ateratzen");
    }

    // http://localhost:8080/websistemak2023/kaixojsp
    // Makina -> Localhost
    // App -> Tomcat 8080
    // web aplikazioa -> websistemak2023
    // xml-ra bidali kaizojsp kudeatzeko

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
