import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Login")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest aReq, HttpServletResponse aResp) throws ServletException, IOException {
        try {
            aResp.setContentType("text/html;charset=UTF-8");
            String usu = aReq.getParameter("usuario");
            String senha = aReq.getParameter("senha");

            if (usu.equals("admin") && senha.equals("1")) {
                aReq.getRequestDispatcher("/LoginSuceso").forward(aReq, aResp);
            } else {
                aResp.sendRedirect("index.html");
            }
        } catch (ServletException | IOException aE) {
            aE.printStackTrace();
        }
    }
}
