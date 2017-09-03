import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ServletSoma")
public class ServletSoma extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        semParametros(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter lPrintWriter = resp.getWriter();
            String lStrOperador1 = req.getParameter("operador1").trim();
            String lStrOperador2 = req.getParameter("operador2").trim();
            if (!lStrOperador1.isEmpty() && !lStrOperador2.isEmpty()) {
                Double lOperador1 = Double.valueOf(lStrOperador1);
                Double lOperador2 = Double.valueOf(lStrOperador2);
                Double lSoma = lOperador1 + lOperador2;
                lPrintWriter.println("<h1>" + " Servlet Soma " + " </h1>");
                lPrintWriter.println("<h1>" + " Soma =  " + String.valueOf(lSoma) + " </h1>");
            } else {
                semParametros(resp);
            }
        } catch (IOException | NumberFormatException aIOexception) {
            aIOexception.printStackTrace();
        }
    }

    private void semParametros(HttpServletResponse aResp) {
        try {
            PrintWriter lPrintWriter = aResp.getWriter();
            lPrintWriter.println("<!DOCTYPE html>");
            lPrintWriter.println("<html>");
            lPrintWriter.println("<head>");
            lPrintWriter.println("<title>OPS !</title>");
            lPrintWriter.println("</head>");
            lPrintWriter.println("<body>");
            lPrintWriter.println("<h1> Sem Parâmetros !</h1>");
            lPrintWriter.println("</body>");
            lPrintWriter.println("</html>");
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }
}
