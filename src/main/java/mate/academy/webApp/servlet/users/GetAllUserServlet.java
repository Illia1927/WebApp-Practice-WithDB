package mate.academy.webApp.servlet.users;

import mate.academy.webApp.dao.hibernateDao.UserDaoHib;
import mate.academy.webApp.dao.hibernateDao.impl.UserDaoHibImpl;
import mate.academy.webApp.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getAll")
public class GetAllUserServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(GetAllUserServlet.class);
    private static final UserDaoHib userDao = new UserDaoHibImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Started show servlet 'get all'");
        req.getRequestDispatcher("CRUD/usersPage/getAllUsers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDao.getAll();
        logger.info("Admin in get all page");
        req.setAttribute("users", users);
        req.getRequestDispatcher("CRUD/usersPage/getAllUsers.jsp").forward(req, resp);
    }
}
