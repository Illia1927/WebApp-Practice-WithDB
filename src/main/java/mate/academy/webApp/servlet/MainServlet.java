package mate.academy.webApp.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/home")
public class MainServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(MainServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Started server");
        logger.info("Located in home page");
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
