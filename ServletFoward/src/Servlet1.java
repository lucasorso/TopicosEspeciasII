import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            RequestDispatcher rd = req.getRequestDispatcher("/Servlet2");
//            rd.include(req, resp); //inclui o conteúdo do servlet atual na resposta
//            rd.forward(req, resp); //não inclui o conteúdo do servlet atual na resposta

            PrintWriter lPrintWriter = resp.getWriter();
            lPrintWriter.println("<h1>Enviando para o servlet 2</h1>");

            String nextJSP = "/Servlet2";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(req, resp);

        } catch (Exception aE) {
            aE.printStackTrace();
        }
    }
}
