package com.example.nirepaketea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private String mezu;

    public void init() throws ServletException{
        mezu=" ";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> LoginServlet ---> doGet() metodoan sartzen");

        response.setHeader("Cache-Control", "no-cache");

        System.out.println("---> LoginServlet ---> datuak lortu");
        String erabiltzailea = request.getParameter("username");
        String pasahitza = request.getParameter("password");

        if (erabiltzailea==null || pasahitza==null){
            System.out.println("<--- LoginServlet <--- JSP-ra berbidaltzen");
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/login_form.jsp");
            rd.forward(request, response);
        }else{
            if(erabiltzailea.equals("ws") && pasahitza.equals("1234")){
                System.out.println("<--- LoginServlet <--- Log in ondo");
                HttpSession session= request.getSession(true);   //Saioa lortu:
                                                                    // True: ez bada existitzen sortu
                                                                    // False: ez bada existitzen EZ sortu
                session.setAttribute("ussername",erabiltzailea);

                System.out.println("---> LoginServlet ---> redirecting to MainServlet");
                ServletContext context = request.getServletContext();
                RequestDispatcher rd = context.getNamedDispatcher("MainServlet"); //web.xml fitxategiko <servlet-name>
                rd.forward(request, response);

                /*response.setContentType("text/plain");
                PrintWriter http_out= response.getWriter();
                http_out.println("Login OK!");
                mezu="Login OK!";
                request.setAttribute("txarto", mezu);*/
            }else if(request.getSession(false)!=null) {
                System.out.println("---> LoginServlet ---> User already logged: redirecting to MainServlet");
                ServletContext context =request.getServletContext();
                RequestDispatcher rd= context.getNamedDispatcher("MainServlet");
                rd.forward(request, response);
            }else{
                mezu ="Login ERROR";
                request.setAttribute("txarto", mezu);
                System.out.println("<--- LoginServlet <--- pasahitza okerra JSP-ra berbidaltzen");
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/login_form.jsp");
                rd.forward(request, response); //pasatu kontrola jsp-ra baina servlet-a bere exekuzioa amaitzen du
            }
        }
        System.out.println("<--- LoginServlet <--- doGet() metodotik ateratzen");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
