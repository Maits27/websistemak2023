package com.example.websistemak2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

//@WebServlet(name = "CacheServlet", value = "/CacheServlet")
public class CacheServlet extends HttpServlet {

    private SimpleDateFormat data_formatua;
    private long lastModified;

    @Override
    public void init() throws ServletException {
        System.out.println("---> HelloServletCache ---> init()");

        data_formatua = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        data_formatua.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));

        long now = System.currentTimeMillis();
        lastModified = now - (now%1000); //Milisegunduak segunduetara
        System.out.println("Hasierako ordua: "+lastModified);

        System.out.println("<--- HelloServletCache <--- init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----> CacheServlet ----> doGet() metodoan sartzen");

        String update = request.getParameter("update");
        if(update != null) {
            long now = System.currentTimeMillis();
            lastModified = now - (now % 1000);

            System.out.println("---> HelloServletCache ---> NEW Last-Modified: " + data_formatua.format(lastModified));
            PrintWriter http_out = response.getWriter();
            http_out.println("Last-Modified eguneratu da: " + data_formatua.format(lastModified));
        } else {
            long ifModifiedSince = request.getDateHeader("If-Modified-Since");
            if (ifModifiedSince >= lastModified) {
                System.out.println("---> HelloServletCache ---> Status: 304");
                response.setStatus(304);
            } else {
                System.out.println("---> HelloServletCache ---> Status: 200");

                response.setDateHeader("Last-Modified", lastModified);
                response.addHeader("Cache-Control", "max-age=15");
                response.setContentType("text/plain; charset=utf-8");

                PrintWriter http_out = response.getWriter();
                http_out.println("Last-Modified: " + data_formatua.format(lastModified));
                http_out.println("If-Modified-Since: " + data_formatua.format(ifModifiedSince));
            }
        }

        System.out.println("<---- CacheServlet <---- doGet() metodotik ateratzen");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
