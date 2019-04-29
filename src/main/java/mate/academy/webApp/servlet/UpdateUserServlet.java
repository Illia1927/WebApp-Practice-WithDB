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

@WebServlet(value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("users_id"));
        System.out.println(id);
        String name = req.getParameter("name");
        String login = req.getParameter("password");
        String email = req.getParameter("email");
        String password = req.getParameter("lastName");
        userDao.updateUser(id, new User(name, login, email, password));

        req.setAttribute("users", userDao.getAllUsers());
        req.getRequestDispatcher("getAll.jsp").forward(req, resp);
    }
}
