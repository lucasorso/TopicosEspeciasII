import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/ServletRiddle")
public class ServletRiddle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String lInicio = req.getParameter("novo");
        Integer lNumeroAleatorio = null;
        Integer lNumeroTentativas = null;
        if (lInicio.equals("true")) {
            lNumeroTentativas = 0;
            lNumeroAleatorio = new Random().nextInt(100);

        }
        String lAdivinhacaoJSP = "/adivinhacao.jsp";
        session.setAttribute("numero_aleatorio", lNumeroAleatorio);
        session.setAttribute("numero_tentativas", lNumeroTentativas);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(lAdivinhacaoJSP);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String lStrNumero = req.getParameter("numero");
        Integer lNumero;
        try {
            lNumero = Integer.valueOf(lStrNumero);
            if (lNumero > 100 || lNumero < 0) {
                interrompeJogo(req, resp, session, new NumeroException("Número inválido"));
            } else {
                String lAcerto;

                Integer lNumeroAleatorio = (Integer) session.getAttribute("numero_aleatorio");
                Integer lNumeroTentativas = (Integer) session.getAttribute("numero_tentativas");

                if (lNumeroTentativas == 10) {
                    reiniciaJogo(resp);
                } else {
                    if (lNumero.equals(lNumeroAleatorio)) {
                        lAcerto = "Acertou !";
                        req.setAttribute("tentativas", lNumeroTentativas);
                        req.setAttribute("acerto", lAcerto);
                        venceJogo(req, resp);
                    } else {
                        lAcerto = "Errou !";
                        lNumeroTentativas++;
                        session.setAttribute("numero_tentativas", lNumeroTentativas);
                        req.setAttribute("tentativas", lNumeroTentativas);
                        req.setAttribute("acerto", lAcerto);
                        continuaJogo(req, resp, session);
                    }
                }
            }
        } catch (NumberFormatException aE) {
            aE.printStackTrace();
            interrompeJogo(req, resp, session, aE);
        }
    }

    private void interrompeJogo(HttpServletRequest aRequest, HttpServletResponse aResponse, HttpSession aHttpSession, Exception aException) {
        if (aException != null) {
            String lMessagemErro;
            if (aException instanceof NumberFormatException) {
                lMessagemErro = aException.getMessage();
            } else if (aException instanceof NumeroException) {
                lMessagemErro = aException.getMessage();
            } else {
                lMessagemErro = "Erro desconhecido !";
            }
            String lPaginaErro = "/error.jsp";
            aRequest.setAttribute("msg_erro", lMessagemErro);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(lPaginaErro);
            try {
                dispatcher.forward(aRequest, aResponse);
            } catch (ServletException | IOException aE) {
                aE.printStackTrace();
            }
        }
    }

    private void venceJogo(HttpServletRequest aReq, HttpServletResponse aResp) {
        try {
            String lAdivinhacaoJSP = "/venceu.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(lAdivinhacaoJSP);
            dispatcher.forward(aReq, aResp);
        } catch (ServletException | IOException aE) {
            aE.printStackTrace();
        }
    }

    private void continuaJogo(HttpServletRequest aRequest, HttpServletResponse aResponse, HttpSession aHttpSession) {
        try {
            String lAdivinhacaoJSP = "/adivinhacao.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(lAdivinhacaoJSP);
            dispatcher.forward(aRequest, aResponse);
        } catch (ServletException | IOException aE) {
            aE.printStackTrace();
        }
    }

    private void reiniciaJogo(HttpServletResponse aResp) {
        try {
            aResp.sendRedirect("/index.html");
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }
}
