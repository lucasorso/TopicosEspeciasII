import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet(urlPatterns = "/ServletAcademia")
public class ServletAcademia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lStringPeso = req.getParameter("peso");
        String lStringAltura = req.getParameter("altura");
        Double lImc = null;
        String lCor = null;
        String lDesc = "";
        try {
            Double lPeso = Double.valueOf(lStringPeso);
            Double lAltura = Double.valueOf(lStringAltura);
            lImc = lPeso / Math.pow(lAltura, 2);
            if (lImc < 20) {
                lCor = "#333300";
                lDesc = "Abaixo do peso";
            } else if (lImc >= 20 && lImc <= 25) {
                lCor = "#3366FF";
                lDesc = "Peso normal";
            } else if (lImc >= 25.1 && lImc <= 29.9) {
                lCor = "blue";
                lDesc = "Sobrepeso";
            } else if (lImc >= 30 && lImc <= 39.9) {
                lCor = "#FF9900";
                lDesc = "Obesa";
            } else {
                lCor = "red";
                lDesc = "Obeso mórbido";
            }
        } catch (NumberFormatException aE) {
            aE.printStackTrace();
        }
        String lAcademiaSLP = "/academia.jsp";
        req.setAttribute("cor", lCor);
        req.setAttribute("imc", new DecimalFormat("#0.00").format(lImc));
        req.setAttribute("desc", lDesc);
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(lAcademiaSLP);
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException aE) {
            aE.printStackTrace();
        }
    }
}
