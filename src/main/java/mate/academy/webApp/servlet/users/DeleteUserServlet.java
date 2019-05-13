package mate.academy.webApp.servlet.users;

import mate.academy.webApp.dao.UserDao;
import mate.academy.webApp.dao.impl.UserDaoImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(DeleteUserServlet.class);
    private static final UserDao userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("userId"));
        userDao.deleteUserById(id);
        logger.info("Admin in delete page");
        req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
    }
}