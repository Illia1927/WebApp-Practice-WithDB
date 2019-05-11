package mate.academy.webApp.servlet.goods;

import mate.academy.webApp.dao.GoodDao;
import mate.academy.webApp.dao.impl.GoodDaoImpl;
import mate.academy.webApp.model.Good;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/getAllGood")
public class AddGoodServlet extends HttpServlet {
    private static final GoodDao goodDao = new GoodDaoImpl();
    private static final Logger logger = Logger.getLogger(AddGoodServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameOfGood = req.getParameter("nameOfGood");
        String description = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        logger.debug("Good : " + nameOfGood + ", " + description
                + ", " + price + ".");
        Good good = new Good(nameOfGood, description, price);
        goodDao.addGood(good);
        req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
    }

}
