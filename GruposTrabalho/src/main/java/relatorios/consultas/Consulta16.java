/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package relatorios.consultas;

import grupo.GrupoBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import util.Util;

/**
 *
 * @author deise
 */
@Transactional
@WebServlet(name = "Consulta16", urlPatterns = {"/Consulta16"})
public class Consulta16 extends HttpServlet {

    @Inject
    private GrupoBeanLocal grupoBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            StringBuilder builder = new StringBuilder();

            builder.append("<!DOCTYPE html>");
            builder.append("<html>");
            builder.append("<head>");
            builder.append("<title>Servlet Consultas</title>");
            builder.append("</head>");
            builder.append("<body>");
            builder.append("<h1>Consulta 16</h1>");
            builder.append("<a href=\"index.html\">Voltar</a>");

            builder.append("<h2>Consulta 16: Quais são os grupos (dados completos) que contêm “II” em seus nomes? </h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getGruposString("II")));
            builder.append("</pre></p>");

            builder.append("<a href=\"index.html\">Voltar</a>");
            builder.append(" <a href=\"Consulta17\">Consulta 17</a>");
            builder.append("</body>");
            builder.append("</html>");

            out.print(builder.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    // </editor-fold>
}