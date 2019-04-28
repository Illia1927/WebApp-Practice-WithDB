package mate.academy.webApp.servlet;

import mate.academy.webApp.dao.UserDao;
import mate.academy.webApp.dao.UserDaoImpl;
import mate.academy.webApp.model.User;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        String userName = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(userName, login, email, password);
        if (userDao.getUserByName(userName).equals(Optional.empty())) {
            if (checkEmail(email)) {
                userDao.addUser(user);
                System.out.println(user);
                req.setAttribute("name", req.getParameter("name"));
            }
        }
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
