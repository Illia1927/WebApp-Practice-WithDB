package mate.academy.webApp.servlet.users;

import mate.academy.webApp.dao.UserDao;
import mate.academy.webApp.dao.impl.UserDaoImpl;
import mate.academy.webApp.model.User;
import mate.academy.webApp.servlet.home.RegistrationServlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addUser")
public class AddUserServlet extends HttpServlet {
    private static final UserDao userDao = new UserDaoImpl();
    private static final Logger logger = Logger.getLogger(AddUserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Started add user to DB");
        req.getRequestDispatcher("CRUD/usersPage/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        User user = new User(userName, login, email, password, role);
        userDao.addUser(user);
        req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
    }
}
