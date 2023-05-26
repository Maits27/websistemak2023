package com.example.websistemak2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "KaixoMVCServlet", value = "/KaixoMVCServlet")
public class KaixoMVCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> KaixoMVCServlet ---> doGet() metodoan sartzen");
        //302 erantzun bat bueltatu, location goiburuan parametro bezala adierazten den URI-a sartuz
        response.sendRedirect("/websistemak2023/html/bista.html");

        System.out.println("<--- KaixoMVCServlet <--- doGet() metodotik ateratzen");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
