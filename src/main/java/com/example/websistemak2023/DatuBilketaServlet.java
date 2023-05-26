package com.example.websistemak2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "DatuBilketaServlet", value = "/DatuBilketaServlet")
public class DatuBilketaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> DatuBilketaServlet ---> doGet() metodoan sartzen");
        String zenbakia = request.getParameter("zenbakia");
        System.out.println("---> DatuBilketaServlet ---> zenbakia lortu");
        int num = Integer.parseInt(zenbakia);
        char [] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int resto = num % 23;

        response.setContentType("text/plain");
        PrintWriter http_out= response.getWriter();
        http_out.println("DNI COMPLETO: "+num+letras[resto]);
        System.out.println("DNI COMPLETO: "+num+letras[resto]);
        System.out.println("<--- DatuBilketaServlet <--- doGet() metodotik ateratzen");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
