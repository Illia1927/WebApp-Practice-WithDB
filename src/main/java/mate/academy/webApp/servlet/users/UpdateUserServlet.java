package mate.academy.webApp.servlet.users;

import mate.academy.webApp.dao.hibernateDao.RoleDaoHib;
import mate.academy.webApp.dao.hibernateDao.UserDaoHib;
import mate.academy.webApp.dao.hibernateDao.impl.RoleDaoHibImpl;
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
import java.util.List;

@WebServlet(value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UpdateUserServlet.class);
    private static final UserDaoHib userDao = new UserDaoHibImpl();
    private static final RoleDaoHib roleDao = new RoleDaoHibImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Admin in update user page");
        Long id = Long.parseLong(req.getParameter("userId"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String user = req.getParameter("user");
        String admin = req.getParameter("admin");
        Role adminRoleFromDb = roleDao.getByLogin("ADMIN").get();
        Role userRoleFromDb = roleDao.getByLogin("USER").get();
        List<Role> roles = new ArrayList<>();
        if (admin.isEmpty() && admin.equals("true")) {
            roles.add(adminRoleFromDb);
        } else {
            roles.add(userRoleFromDb);
        }
        logger.debug("User " + name + " entered date : " + login
                + ", " + email +  ".");
        User userUpdate = new User(name, login, email);
        userUpdate.setUserId(id);
        userUpdate.setRoles(roles);
        userDao.update(userUpdate);
        req.setAttribute("users", userDao.getAll());
        req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
    }
}
