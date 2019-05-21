package mate.academy.webApp.servlet.goods;

import mate.academy.webApp.dao.GoodDao;
import mate.academy.webApp.dao.impl.GoodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/goods")
public class AllGoodsServlet extends HttpServlet {
    private static final GoodDao goodDao = new GoodDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("goods", goodDao.getAllGood());
        req.getRequestDispatcher("CRUD/goodsPage/allGoodsPage.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
