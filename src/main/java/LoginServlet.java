import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Holder forbindelsen så længe serveren kører (applikation scope)
        ServletContext servletContext = getServletContext();

        //Her opretter jeg session
        HttpSession session = request.getSession();

        String navn = request.getParameter("Navn");
        String kodeord = request.getParameter("Kodeord");


        if (servletContext.getAttribute("brugerMap") == null) {
            //Lav et map af navne, hvis der ikke er nogle
            Map<String, String> brugerMap = new HashMap<>();

            //Faste brugere
            brugerMap.put("test","test");
            brugerMap.put("admin","1234");

            servletContext.setAttribute("brugerMap", brugerMap);
        }

        if (!((Map<String, String>) servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            //todo Gå til login side
            request.setAttribute("besked", "Brugernavnet findes ikke, her kan du oprette dig som bruger.");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);

        }

        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {




            //todo Gå til adminside
            if (navn.equalsIgnoreCase("admin")) {
                request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request,response);
            }

            //todo Gå til huskelisten
            //Sætter brugernavnet på session
            session.setAttribute("besked", "Du er logget ind med navnet " + navn);

            request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request,response);
        }

        //todo Gå til login dvs. index siden

        request.setAttribute("besked", "Din kode var forkert, prøv igen.");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
