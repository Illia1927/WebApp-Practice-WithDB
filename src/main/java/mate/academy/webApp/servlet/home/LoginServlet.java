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
public class LoginServlet extends HttpServlet {
    private static final UserDaoHib userDao = new UserDaoHibImpl();
    private static final RoleDaoHib roleDao = new RoleDaoHibImpl();
    private static final Logger logger = Logger.getLogger(LoginServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("User started log in system");
        req.getRequestDispatcher("user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkUser(req, resp);
    }

    private static void checkUser(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        logger.debug("User entered the user name : " + name + ", and pass : some pass!");
        Optional<User> userFromDb = userDao.getByLogin(name);
        Role byNameFormDbUser = roleDao.getByLogin("USER").get();
        Role byNameFormDbAdmin = roleDao.getByLogin("ADMIN").get();
        if (userFromDb.isPresent()) {
            User user = userFromDb.get();
            String salt = user.getSalt();
            String passwordEncoder = PasswordEncoder.getEncodePassword(password, salt);
            req.getSession().setAttribute("user", user);
            if (user.getPassword().equals(passwordEncoder) & user.getRoles().contains(byNameFormDbUser)) {
                System.out.println(user);
                req.setAttribute("name", name);
                logger.debug("User " + user.getName() + " logged in system");
                try {
                    req.getRequestDispatcher("user/helloPage.jsp").forward(req, resp);
                } catch (ServletException | IOException e) {
                    logger.error("Can`t forward to allGoodsPage.jsp", e);
                }
            } else if (user.getPassword().equals(passwordEncoder) & user.getRoles().contains(byNameFormDbAdmin)) {
                logger.debug("Admin " + user.getName() + " logged in system");
                try {
                    req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
                } catch (ServletException | IOException e) {
                    logger.error("Can`t forward to adminPage.jsp", e);
                }
            } else {
                try {
                    req.getRequestDispatcher("home.jsp").forward(req, resp);
                } catch (ServletException | IOException e) {
                    logger.error("Can`t forward to homePage.jsp", e);
                }
            }
        }
    }
}
