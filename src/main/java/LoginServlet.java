import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Holder forbindelsen så længe serveren kører (applikation scope)
        ServletContext servletContext = getServletContext();

        String navn = request.getParameter("Navn");
        String kodeord = request.getParameter("Kodeord");

        if (servletContext.getAttribute("brugerMap") == null) {
            //Lav et map af navne, hvis der ikke er nogle
            Map<String, String> brugerMap = new HashMap<>();

            //Testbruger
            brugerMap.put("test","test");

            servletContext.setAttribute("brugerMap", brugerMap);
        }

        if (!((Map<String, String>) servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            //todo Gå til login side
            request.setAttribute("besked", "Brugernavnet findes ikke.");
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            //todo Gå til huskelisten

            request.getRequestDispatcher("/WEB-INF/HuskeListe.jsp").forward(request,response);
        }

        //todo Gå til login dvs. index siden

        request.setAttribute("besked", "Din kode var forkert, prøv igen.");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
