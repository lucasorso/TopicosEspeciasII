import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Servlet2")
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter lPrintWriter = resp.getWriter();
            lPrintWriter.println("<!DOCTYPE html>");
            lPrintWriter.println("<html>");
            lPrintWriter.println("<head>");
            lPrintWriter.println("</head>");
            lPrintWriter.println("<body>");
            lPrintWriter.println("<h1> GET Servlet2 </h1>");
            lPrintWriter.println("</body>");
            lPrintWriter.println("</html>");
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse aResp) throws ServletException, IOException {
        try {
            PrintWriter lPrintWriter = aResp.getWriter();
            lPrintWriter.println("<!DOCTYPE html>");
            lPrintWriter.println("<html>");
            lPrintWriter.println("<head>");
            lPrintWriter.println("<title>FAUSTOP</title>");
            lPrintWriter.println("</head>");
            lPrintWriter.println("<body>");
            lPrintWriter.println("<h1> RECEBI </h1>");
            lPrintWriter.println("<h1> "+ req.getParameter("request") + "</h1>");
            lPrintWriter.println("</body>");
            lPrintWriter.println("</html>");
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }
}
