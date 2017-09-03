import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletAniversario")
public class ServletAniversario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lMes = req.getParameter("mes");
        System.out.println("Mês: " + lMes);
        if (lMes == null) {
            lMes = "Mês não informado";
        }
        String lAniverJSLP = "/aniversario.jsp";
        try {
            req.setAttribute("mes_selecionado", lMes);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(lAniverJSLP);
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException aE) {
            aE.printStackTrace();
        }
    }
}
