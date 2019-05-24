package mate.academy.webApp.servlet.home;

import mate.academy.webApp.dao.hibernateDao.RoleDaoHib;
import mate.academy.webApp.dao.hibernateDao.UserDaoHib;
import mate.academy.webApp.dao.hibernateDao.impl.RoleDaoHibImpl;
import mate.academy.webApp.dao.hibernateDao.impl.UserDaoHibImpl;
import mate.academy.webApp.model.Role;
import mate.academy.webApp.model.User;
import mate.academy.webApp.utill.PasswordEncoder;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/login")
public class LogInServlet extends HttpServlet {
    private static final UserDaoHib userDao = new UserDaoHibImpl();
    private static final RoleDaoHib roleDao = new RoleDaoHibImpl();
    private static final Logger logger = Logger.getLogger(LogInServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("User started log in system");
        req.getRequestDispatcher("user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        logger.debug("User entered the user name : " + name);
        String link = checkUser(name, req);

        req.getRequestDispatcher(link).forward(req, resp);
    }

    private String checkUser(String name, HttpServletRequest req) {
        Optional<User> userFromDb = userDao.getByLogin(name);
        if (userFromDb.isPresent()) {
            return checkPass(userFromDb.get(), req);
        }
        return "";
    }

    private String checkPass(User user, HttpServletRequest req) {
        String password = req.getParameter("password");
        String salt = user.getSalt();
        String passwordEncoder = PasswordEncoder.getEncodePassword(password, salt);
        String passFromDb = user.getPassword();
        if (passwordEncoder.equals(passFromDb)) {
            return checkUserRole(user, req);
        }
        return "";
    }

    private String checkUserRole(User user, HttpServletRequest req) {
        req.getSession().setAttribute("user", user);
        Role adminRole = roleDao.getByLogin("ADMIN").get();
        if (user.getRoles().contains(adminRole)) {
            return "admin/adminPage.jsp";
        }
        return "user/helloPage.jsp";
    }
}
