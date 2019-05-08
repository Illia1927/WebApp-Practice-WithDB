package mate.academy.webApp.servlet;

import mate.academy.webApp.dao.UserDao;
import mate.academy.webApp.dao.impl.UserDaoImpl;
import mate.academy.webApp.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final UserDao userDao = new UserDaoImpl();
    private static final Logger logger = Logger.getLogger(RegistrationServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Started registration");
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        logger.debug("User " + userName + " entered date : " + login
                + ", " + email + ", " + password + ".");
        User user = new User(userName, login, email, password, "USER");
        Long id = userDao.addUser(user);
        user.setUserId(id);
        req.getSession().setAttribute("user", user);
        if (userDao.getUserByName(userName).equals(Optional.empty())) {
            logger.debug("User is unique, password such as entered");
            if (checkEmail(email)) {
                logger.debug("Mail is ok");
                userDao.addUser(user);
                logger.debug("User : " + user);
                req.setAttribute("name", req.getParameter("name"));
            }
        }
        logger.debug("Moved to 'hello page'");
        req.getRequestDispatcher("nihao.jsp").forward(req, resp);
    }

    private static boolean checkEmail(String email) {
        Pattern emailPattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
