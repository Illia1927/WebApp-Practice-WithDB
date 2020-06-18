package mate.academy.webApp.servlet.goods;

import mate.academy.webApp.dao.hibernateDao.GoodDaoHib;
import mate.academy.webApp.dao.hibernateDao.impl.GoodDaoHibImpl;
import mate.academy.webApp.model.Good;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteGood")
public class DeleteGoodServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(DeleteGoodServlet.class);
    private static final GoodDaoHib goodDao = new GoodDaoHibImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("goodId"));
        goodDao.delete(id);
        logger.info("Admin in delete page");
        req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
    }
}
