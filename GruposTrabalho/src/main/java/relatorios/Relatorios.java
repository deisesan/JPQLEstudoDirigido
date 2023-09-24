/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package relatorios;

import grupo.GrupoBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import pessoa.PessoaBeanLocal;
import util.Util;

/**
 *
 * @author deise
 */
@Transactional
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios"})
public class Relatorios extends HttpServlet {

    @Inject
    private PessoaBeanLocal pessoaBean;

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
            builder.append("<h1>Estudo Dirigido: Jakarta Persistence Query Language</h1>");
            builder.append("<a href=\"index.html\">Voltar</a>");

            /* Consulta 1 */
            builder.append("<h2>Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 1.B: Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasTypedQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 1.C: Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasNamedQuery()));
            builder.append("</pre></p>");

            /* Consulta 2 */
            builder.append("<h2>Consulta 2.A: Quais os nomes das pessoas? Por meio de Query</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getNomesQuery()));
            builder.append("</pre></p>");

            builder.append("<h2>Consulta 2.B: Quais os nomes das pessoas? Por meio de TypedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getNomesTypedQuery()));
            builder.append("</pre></p>");

            builder.append("<h2>Consulta 2.C: Quais os nomes das pessoas? Por meio de NamedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getNomesNamedQuery()));
            builder.append("</pre></p>");

            /* Consulta 3 */
            builder.append(
                    "<h2>Consulta 3.A: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de Query</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasEnderecosQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 3.B: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de TypedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasEnderecosTypedQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 3.C: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? Por meio de NamedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasEnderecosNamedQuery()));
            builder.append("</pre></p>");

            /* Consulta 4 */
            builder.append(
                    "<h2>Consulta 4.A: Quais pessoas (dados completos) moram em avenidas? Por meio de Query</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasAvenidasQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 4.B: Quais pessoas (dados completos) moram em avenidas? Por meio de TypedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasAvenidasTypedQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 4.C: Quais pessoas (dados completos) moram em avenidas? Por meio de NamedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasAvenidasNamedQuery()));
            builder.append("</pre></p>");

            /* Consulta 5 */
            builder.append(
                    "<h2>Consulta 5.A: Quais pessoas (dados completos) não moram em praças? Por meio de Query</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasNaoPracasQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 5.B: Quais pessoas (dados completos) não moram em praças? Por meio de TypedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasNaoPracasTypedQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 5.C: Quais pessoas (dados completos) não moram em praças? Por meio de NamedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasNaoPracasNamedQuery()));
            builder.append("</pre></p>");

            /* Consulta 6 */
            builder.append(
                    "<h2>Consulta 6.A: Quais pessoas (nomes) e seus respectivos telefones (dados completos)? Por meio de Query</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getNomesTelefonesQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 6.B: Quais pessoas (nomes) e seus respectivos telefones (dados completos)? Por meio de TypedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getNomesTelefonesTypedQuery()));
            builder.append("</pre></p>");

            builder.append(
                    "<h2>Consulta 6.C: Quais pessoas (nomes) e seus respectivos telefones (dados completos)? Por meio de NamedQuery</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getNomesTelefonesNamedQuery()));
            builder.append("</pre></p>");

            /* Consulta 7 */
            builder.append("<h2>Consulta 7: Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasAniversarios(LocalDate.of(2001, Month.APRIL, 1),
                    LocalDate.of(2004, Month.APRIL, 30))));
            builder.append("</pre></p>");

            /* Consulta 8 */
            builder.append("<h2>Consulta 8.A: Quais pessoas (dados completos) têm telefone do estado do Paraná?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasTelefonesEstado((byte) 44)));
            builder.append("</pre></p>");

            builder.append("<h2>Consulta 8.B: Quais pessoas (dados completos) têm telefone do estado do Rio de Janeiro?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasTelefonesEstado((byte) 22)));
            builder.append("</pre></p>");

            /* Consulta 9 */
            builder.append(
                    "<h2>Consulta 9: Quais pessoas (dados completos) não possuem telefone?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getPessoasNaoTelefones()));
            builder.append("</pre></p>");

            /* Consulta 10 */
            builder.append(
                    "<h2>Consulta 10: Quantos telefones cada pessoa (nome) tem?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getNomeCountTelefones()));
            builder.append("</pre></p>");

            /* Consulta 11 */
            builder.append(
                    "<h2>Consulta 11: Quais grupos (dados completos) não estão ativos?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getGruposNaoAtivos()));
            builder.append("</pre></p>");

            /* Consulta 12 */
            builder.append(
                    "<h2>Consulta 12: Quais são os líderes (nomes) dos grupos (nomes)?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getNomesLideresGruposNomes()));
            builder.append("</pre></p>");

            /* Consulta 13 */
            builder.append(
                    "<h2>Consulta 13: Quais são os membros (nomes) do grupo com nome \"Estudo IV\" com\n"
                    + "ordenação alfabética inversa?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(pessoaBean.getNomesGrupoInverso("Estudo IV")));
            builder.append("</pre></p>");

            /* Consulta 14 */
            builder.append(
                    "<h2>Consulta 14: Quais são os grupos (dados completos) liderados por “Beatriz Yana”?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getGruposLiderados("Beatriz Yana")));
            builder.append("</pre></p>");

            /* Consulta 15 */
            builder.append(
                    "<h2>Consulta 15: Quais são as datas de início e de término da atuação e os grupos (nomes) nos\n"
                    + "quais \"Cecília Xerxes\" é membro?</h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getDatasNomeGrupo("Cecília Xerxes")));
            builder.append("</pre></p>");

            /* Consulta 16 */
            builder.append("<h2>Consulta 16: Quais são os grupos (dados completos) que contêm “II” em seus nomes? </h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getGruposString("II")));
            builder.append("</pre></p>");

            /* Consulta 17 */
            builder.append("<h2>Consulta 17: Quais são os grupos (nomes) e os respectivos totais de membros distintos já alocados? </h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getNomesGruposTotaisMembros()));
            builder.append("</pre></p>");

            /* Consulta 18 */
            builder.append("<h2>Consulta 18: Quais grupos (nomes) têm 3 ou mais atuações de membros e quanto são esses totais de atuações? </h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getNomesGruposTotaisMembrosFiltro((long) 3)));
            builder.append("</pre></p>");

            /* Consulta 19 */
            builder.append("<h2>Consulta 19: Quais membros (nomes) entraram a partir de 2012 no primeiro grupo? </h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getNomesDataFiltroAno((long) 1,
                    LocalDate.of(2012, Month.JANUARY, 1))));
            builder.append("</pre></p>");

            /* Consulta 20 */
            builder.append("<h2>Consulta 20: Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que "
                    + "entraram a partir de 2012 em qualquer grupo? </h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(
                    grupoBean.getNomesGruposMembrosData(LocalDate.of(2012, Month.JANUARY, 1))));
            builder.append("</pre></p>");

            /* Consulta 21 */
            builder.append("<h2>Consulta 20: Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que "
                    + "entraram a partir de 2012 em qualquer grupo? </h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getNomesGruposMembrosData(LocalDate.of(2012, Month.JANUARY, 1))));
            builder.append("</pre></p>");

            /* Consulta 22 */
            builder.append("<h2>Consulta 22: Quais são os grupos (nomes) e líderes (nomes) com respectivos membros (nomes)? </h2>");
            builder.append("<p><pre>");
            builder.append(Util.toJson(grupoBean.getNomesGruposLideresMembros()));
            builder.append("</pre></p>");

            builder.append("<a href=\"index.html\">Voltar</a>");
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
