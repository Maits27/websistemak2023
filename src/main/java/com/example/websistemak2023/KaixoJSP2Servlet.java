package com.example.websistemak2023;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "KaixoJSPServlet", value = "/KaixoJSPServlet")
public class KaixoJSP2Servlet extends HttpServlet {

    private String zerrenda[];

    public void init() throws ServletException{
        zerrenda = new String[]{"bat", "bi", "hiru"};
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> KaixoJSP2Servlet ---> doGet() metodoan sartzen");

        //HTTP eskaera adierazten duen objektuan atributu bat gehitu atrubutu hori 'message' String delarik
        request.setAttribute("arraya", zerrenda);

        // aplikazioaren fluxua servlet-etik JSP batera pasatuko dugu
        System.out.println("---> KaixoJSP2Servlet ---> /jsp/bista2.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/bista2.jsp");
        rd.forward(request, response); //pasatu kontrola jsp-ra baina servlet-a bere exekuzioa amaitzen du

        System.out.println("<--- KaixoJSP2Servlet <--- doGet() metodotik ateratzen");
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
