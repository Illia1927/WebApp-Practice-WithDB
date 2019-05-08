package mate.academy.webApp.servlet;

import mate.academy.webApp.dao.GoodDao;
import mate.academy.webApp.dao.impl.GoodDaoImpl;
import mate.academy.webApp.model.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/goods")
public class AllGoodsServlet extends HttpServlet {
    private static final GoodDao goodDao = new GoodDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("allGoodsPage.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Good> allGood = goodDao.getAllGood();
        req.setAttribute("goods", allGood);
        req.getRequestDispatcher("allGoodsPage.jsp").forward(req, resp);
    }
}
