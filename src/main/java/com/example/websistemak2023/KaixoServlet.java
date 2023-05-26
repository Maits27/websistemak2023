package com.example.websistemak2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "KaixoServlet", value = "/KaixoServlet")
public class KaixoServlet extends HttpServlet { //HTTP eskaeraz kudeatzeaz arduratu servlet-a

    private String message;

    public void init() throws ServletException{
        message = "Kaixo, Mundua!";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Kaixo Servlet ---> doGet() metodoan sartzen");

        //response.setHeader("Content-Type", "text/html");
        response.setContentType("text/html");

        PrintWriter http_erantzunaren_edukia = response.getWriter();
        http_erantzunaren_edukia.println("<html><body>");
        http_erantzunaren_edukia.println("<h1>"+message+"</h1>");
        http_erantzunaren_edukia.println("</html></body>");

        System.out.println("<--- Kaixo Servlet <--- doGet() metodotik ateratzen");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
