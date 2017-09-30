package controller.atividade;

import model.atividade.Atividade;
import model.atividade.Nota;
import model.atividade.repository.AtividadeRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Lucas
 */
@WebServlet(name = "AtividadeControl", urlPatterns = {"/salvar", "/listar", "/novo", "/editar", "/remover", "/concluir", "/notas", "/salvarNota", "/excluirNota", "/editarNota", "/cadastroNota"})
public class AtividadeControl extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String lJsp;
        String lJspAction = request.getServletPath();

        if (lJspAction.endsWith("/salvar")) {
            lJsp = salvar(request, response);
        } else if (lJspAction.endsWith("/listar")) {
            lJsp = listar(request, response);
        } else if (lJspAction.endsWith("/novo")) {
            lJsp = novo(request, response);
        } else if (lJspAction.endsWith("/editar")) {
            lJsp = editar(request, response);
        } else if (lJspAction.endsWith("/remover")) {
            lJsp = remover(request, response);
        } else if (lJspAction.endsWith("/concluir")) {
            lJsp = concluir(request, response);
        } else if (lJspAction.endsWith("/notas")) {
            lJsp = notas(request, response);
        } else if (lJspAction.endsWith("/salvarNota")) {
            lJsp = salvarNota(request, response);
        } else if (lJspAction.endsWith("/excluirNota")) {
            lJsp = excluirNota(request, response);
        } else if (lJspAction.endsWith("/editarNota")) {
            lJsp = editarNota(request, response);
        } else if (lJspAction.endsWith("/cadastroNota")) {
            lJsp = cadastrarNota(request, response);
        } else {
            lJsp = null;
        }
        if (lJsp == null || lJsp.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/novo");
        } else {
            request.getRequestDispatcher(lJsp).forward(request, response);
        }
    }

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

    private String salvar(HttpServletRequest request, HttpServletResponse response) {
        String lStringCodigo = request.getParameter("codigo");
        Integer lCodigo = Integer.valueOf(lStringCodigo);
        String lDescricao = request.getParameter("descricao");
        String lStringEstagio = request.getParameter("estagio");
        Integer lEstagio = Integer.valueOf(lStringEstagio);
        Atividade lAtividade = AtividadeRepo.getAtividade(lCodigo);
        if (lAtividade == null) {
            lAtividade = new Atividade();
            lAtividade.setCodigo(lCodigo);
            lAtividade.setDescricao(lDescricao);
            lAtividade.setDataCadastro(new Date());
            lAtividade.setEstagio(lEstagio);
            AtividadeRepo.salvar(lAtividade);
        } else  {
            lAtividade.setEstagio(lEstagio);
            lAtividade.setDescricao(lDescricao);
        }
        return "/listar";
    }

    private String listar(HttpServletRequest request, HttpServletResponse response) {
        List<Atividade> lista = AtividadeRepo.getListaAtividades();
        request.setAttribute("lista", lista);
        return "/listagem.jsp";
    }

    private String novo(HttpServletRequest request, HttpServletResponse response) {
        List<Atividade> lista = AtividadeRepo.getListaAtividades();
        request.setAttribute("lista", lista);
        return "/cadastro.jsp";
    }

    private String editar(HttpServletRequest request, HttpServletResponse response) {
        String sCodigo = request.getParameter("codigo");
        Integer codigo = Integer.valueOf(sCodigo);
        Atividade a = AtividadeRepo.getAtividade(codigo);
        if (new Integer(100).compareTo(a.getEstagio()) == 0) {
            return "listar";
        }
        request.setAttribute("e", a);
        return "/novo";
    }

    private String remover(HttpServletRequest request, HttpServletResponse response) {
        String sCodigo = request.getParameter("codigo");
        Integer codigo = Integer.valueOf(sCodigo);
        AtividadeRepo.getListaAtividades().remove(AtividadeRepo.getAtividade(codigo));
        return "/listar";
    }

    private String concluir(HttpServletRequest request, HttpServletResponse response) {
        String lStringCodigo = request.getParameter("codigo");
        Integer lCodigo = Integer.valueOf(lStringCodigo);
        Atividade lAtividade = AtividadeRepo.getAtividade(lCodigo);
        if (lAtividade != null) {
            lAtividade.setEstagio(100);
        }
        return "/listar";
    }

    private String notas(HttpServletRequest request, HttpServletResponse response) {
        String sCodigo = request.getParameter("codigo");
        Integer codigo = Integer.valueOf(sCodigo);
        Atividade lAtividade = AtividadeRepo.getAtividade(codigo);
        request.setAttribute("e", lAtividade);
        request.setAttribute("lista", lAtividade.getNotasList());
        return "notas.jsp";
    }

    private String salvarNota(HttpServletRequest aRequest, HttpServletResponse aResponse) {
        String lStringCodigoAtividade = aRequest.getParameter("codigoAtv");
        Integer lCodigoAtividade = Integer.valueOf(lStringCodigoAtividade);
        String lStringCodigoNota = aRequest.getParameter("codigo");
        Integer lCodigoNota = Integer.valueOf(lStringCodigoNota);
        String lDecricaoNota = aRequest.getParameter("descricao");
        Atividade lAtividade = AtividadeRepo.getAtividade(lCodigoAtividade);
        if (lAtividade != null) {
            Nota lNota = lAtividade.getNota(lCodigoNota);
            if (lNota != null) {
                lNota = lAtividade.getNota(lCodigoNota);
                lNota.setDescricaoNota(lDecricaoNota);
                aRequest.setAttribute("e", lAtividade);
                aRequest.setAttribute("notas", lAtividade.getNotasList());
            } else {
                lNota = new Nota();
                lNota.setCodigo(lCodigoNota);
                lNota.setDescricaoNota(lDecricaoNota);
                lNota.setDataCadastro(new Date());
                lAtividade.addNota(lNota);
                aRequest.setAttribute("e", lAtividade);
                aRequest.setAttribute("notas", lAtividade.getNotasList());
            }
        }
        return "notas.jsp";
    }

    private String excluirNota(HttpServletRequest request, HttpServletResponse response) {
        String sCodigoAtv = request.getParameter("codigoAtv");
        Integer codigoAtv = Integer.valueOf(sCodigoAtv);
        String sCodigo = request.getParameter("codigo");
        Integer codigo = Integer.valueOf(sCodigo);
        Nota lNota = AtividadeRepo.getAtividade(codigoAtv).getNota(codigo);
        AtividadeRepo.getAtividade(codigoAtv).getNotasList().remove(lNota);
        request.setAttribute("e", AtividadeRepo.getAtividade(codigoAtv));
        return "/notas.jsp";
    }

    private String editarNota(HttpServletRequest request, HttpServletResponse response) {
        String lStringCodigoAtividade = request.getParameter("codigoAtv");
        Integer lCodigoAtividade = Integer.valueOf(lStringCodigoAtividade);
        Atividade lAtividade = AtividadeRepo.getAtividade(lCodigoAtividade);
        if (request.getParameterMap().containsKey("codigo") && lAtividade != null) {
            String sCodigo = request.getParameter("codigo");
            Integer lCodigoNota = Integer.valueOf(sCodigo);
            Nota lNota = lAtividade.getNota(lCodigoNota);
            request.setAttribute("n", lNota);
            request.setAttribute("e", lAtividade);
            return "/cadastro_nota.jsp";
        }
        return "/notas.jsp";
    }

    private String cadastrarNota(HttpServletRequest aRequest, HttpServletResponse aResponse) {
        String lStringCodigoAtividade = aRequest.getParameter("codigoAtv");
        Integer lCodigoAtividade = Integer.valueOf(lStringCodigoAtividade);
        aRequest.setAttribute("e", AtividadeRepo.getAtividade(lCodigoAtividade));
        return "/cadastro_nota.jsp";
    }
}
