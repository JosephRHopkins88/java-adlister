import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name="WebPageCountServlet", urlPatterns = "/count")
public class HelloWorldServlet extends HttpServlet {
    int countViews = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if(req.getParameter("reset") != null)
            countViews = 0;
        else
            countViews += 1;
        out.println("<h1>The count is currently at " + countViews + "</h1>");

    }
}
