import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/ServletCardapio"})
public class ServletCardapio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        semParametros(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cardapio</title>");
            out.println("</head>");
            out.println("<body>");
            int valor = 0;
            String[] opcao = req.getParameterValues("opcao");
            if (opcao != null) {
                for (String anOpcao : opcao) {
                    valor = valor + Integer.valueOf(anOpcao);
                }
                out.print("<h1>Valor: " + valor + "<h1>");
            } else {
                semParametros(req, resp);
            }
            out.println("</body>");
            out.println("</html>");
        } catch (IOException | NumberFormatException aE) {
            aE.printStackTrace();
        }
    }

    private void semParametros(HttpServletRequest aRequest, HttpServletResponse aResponse){
        try {
            PrintWriter lPrintWriter = aResponse.getWriter();
            lPrintWriter.println("<!DOCTYPE html>");
            lPrintWriter.println("<html>");
            lPrintWriter.println("<head>");
            lPrintWriter.println("<title>Servlet Cardapio</title>");
            lPrintWriter.println("</head>");
            lPrintWriter.println("<body>");
            lPrintWriter.print("<h1>Escolha uma opção !<h1>");
            lPrintWriter.println("</body>");
            lPrintWriter.println("</html>");
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }
}
