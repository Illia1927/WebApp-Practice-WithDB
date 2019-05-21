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

@WebServlet(value = "/updateGood")
public class UpdateGoodsServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UpdateGoodsServlet.class);
    private static final GoodDaoHib goodDao = new GoodDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Admin in update good page");
        Long id = Long.parseLong(req.getParameter("goodId"));
        String nameOfGood = req.getParameter("nameOfGood");
        String description = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        logger.debug("New good : " + nameOfGood + ", " + description
                + ", " + price + ".");
        goodDao.update(id, new Good(nameOfGood, description, price));
        req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
    }
}
