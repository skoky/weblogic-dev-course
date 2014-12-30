package com.skoky.logging;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/log")
public class LoggingServlet extends HttpServlet {

    private final static Logger log4j = Logger.getLogger(HttpServlet.class);
    private static final java.util.logging.Logger logJ =
            java.util.logging.Logger.getLogger(HttpServlet.class.getSimpleName());


    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        String message = request.getParameter("message");
        System.out.println("System out log:" + message);
        log4j.debug("Log4j log:" + message);
        logJ.finer("Java log:"+message);

        getServletConfig().getServletContext().getRequestDispatcher("/").forward(request, response);
    }

}