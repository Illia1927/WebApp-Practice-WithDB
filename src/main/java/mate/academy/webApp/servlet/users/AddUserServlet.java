package mate.academy.webApp.servlet.users;

import mate.academy.webApp.dao.hibernateDao.UserDaoHib;
import mate.academy.webApp.dao.hibernateDao.impl.UserDaoHibImpl;
import mate.academy.webApp.model.Role;
import mate.academy.webApp.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@WebServlet(value = "/addUser")
public class AddUserServlet extends HttpServlet {
    private static final UserDaoHib userDao = new UserDaoHibImpl();
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
        List<Role> rolesUserSet = new ArrayList<>();
        if (role.equals("USER")) {
            Role roleUser = new Role("USER");
            rolesUserSet.add(roleUser);
        } else {
            Role roleUser = new Role("ADMIN");
            rolesUserSet.add(roleUser);
        }
        User user = new User(userName, login, email, password, rolesUserSet);
        userDao.add(user);
        req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
    }
}
