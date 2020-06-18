package mate.academy.webApp.servlet.goods;

import mate.academy.webApp.dao.hibernateDao.GoodDaoHib;
import mate.academy.webApp.dao.hibernateDao.impl.GoodDaoHibImpl;
import mate.academy.webApp.model.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/goods")
public class AllGoodsServlet extends HttpServlet {
    private static final GoodDaoHib goodDao = new GoodDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("goods", goodDao.getAll(Good.class));
        req.getRequestDispatcher("CRUD/goodsPage/allGoodsPage.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
