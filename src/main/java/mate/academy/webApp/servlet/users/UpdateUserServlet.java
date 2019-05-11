package mate.academy.webApp.servlet.users;

import mate.academy.webApp.dao.UserDao;
import mate.academy.webApp.dao.impl.UserDaoImpl;
import mate.academy.webApp.model.User;
import mate.academy.webApp.utill.PasswordEncoder;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UpdateUserServlet.class);
    private static final UserDao userDao = new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Admin in update user page");
        Long id = Long.parseLong(req.getParameter("userId"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        logger.debug("User " + name + " entered date : " + login
                + ", " + email +  ".");
        userDao.updateUser(id, new User(name, login, email, password, role));
        req.setAttribute("users", userDao.getAllUsers());
        req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
    }
}
