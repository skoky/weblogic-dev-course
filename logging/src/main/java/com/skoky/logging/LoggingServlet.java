package com.skoky.logging;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import weblogic.logging.NonCatalogLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;

@WebServlet("/log")
public class LoggingServlet extends HttpServlet {

    private final static Logger log4j = Logger.getLogger(LoggingServlet.class);
    private static final java.util.logging.Logger logJ =
            java.util.logging.Logger.getLogger(LoggingServlet.class.getSimpleName());
    private static final NonCatalogLogger wlslogger = new NonCatalogLogger("MyPerfectApp");


    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        ConsoleAppender ca = new ConsoleAppender();
        ca.setWriter(new OutputStreamWriter(System.out));
        ca.setLayout(new PatternLayout("%-5p [%t]: %m%n"));
        log4j.addAppender(ca);

        String message = request.getParameter("message");

        System.out.println("System out log :" + message);
        log4j.debug("Log4j log:" + message);
        logJ.severe("Java log:" + message);

        wlslogger.warning("WLS log:"+message);

        System.out.println("Done");

        getServletConfig().getServletContext().getRequestDispatcher("/").forward(request, response);
    }

}