package com.mycompany.onlinestore.frontend.controller;

import com.mycompany.backend.entity.Catalogue;
import com.mycompany.backend.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkDetailServlet", urlPatterns = "/work-details")
public class WorkDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8 ");

        Long id = Long.parseLong(req.getParameter("id"));

        Work work = null;

        for (Work work1 : Catalogue.listOfWorks){
            if (id == work1.getId()){
                work = work1;
                break;
            }
        }

        PrintWriter out = resp.getWriter(); // ouverture flux en écriture

        out.println("<html><body>");
        out.println("<head> </head>");
        out.println("<div style='display: flex; flex-direction : column;'>");
        out.println("<h1 style='color: red;'>" + work.getTitle() + "</h1>");
        out.println("<h2> Titre : " + work.getTitle() + "</h4>");
        out.println("<h4> id : " + work.getId() + "</h4>");
        out.println("<h4> Realisation : " + work.getRelease() + "</h4>");
        out.println("<h4> Genre : " + work.getGenre() + "</h4>");
        out.println("<h4> Résumé : " + work.getSummary() + "</h4>");
        out.println("</div>");

        out.println("</body></html>");
    }
}
