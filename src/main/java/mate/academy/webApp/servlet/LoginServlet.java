package mate.academy.webApp.servlet;

import mate.academy.webApp.dao.UserDao;
import mate.academy.webApp.dao.UserDaoImpl;
import mate.academy.webApp.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    private static final UserDao userDao = new UserDaoImpl();
    private static final Logger logger = Logger.getLogger(LoginServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("User started log in system");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkUser(req, resp);
    }

    private static void checkUser(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        logger.debug("User entered the user name : " + name + ", and pass : " + password + "!");
        Optional<User> userFromDb = userDao.getUserByName(name);
        if (userFromDb.isPresent()) {
            User user = userFromDb.get();
            if (user.getPassword().equals(password) & user.getRole().equals(User.ROLE.USER)) {
                req.setAttribute("name", name);
                logger.debug("User " + user.getName() + " logged in system");
                try {
                    req.getRequestDispatcher("userPage.jsp").forward(req, resp);
                } catch (ServletException | IOException e) {
                    logger.error("Can`t forward to userPage.jsp", e);
                }
            } else {
                logger.debug("Admin " + user.getName() + " logged in system");
                try {
                    req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
                } catch (ServletException | IOException e) {
                    logger.error("Can`t forward to adminPage.jsp", e);
                }
            }
        }
        try {
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            logger.error("Can`t forward to homePage.jsp", e);
        }
    }
}
