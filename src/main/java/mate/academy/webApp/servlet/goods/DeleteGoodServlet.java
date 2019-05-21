package mate.academy.webApp.servlet.goods;

import mate.academy.webApp.dao.GoodDao;
import mate.academy.webApp.dao.impl.GoodDaoImpl;
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
    private static final GoodDao goodDao = new GoodDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("goodId"));
        goodDao.deleteGoodById(id);
        logger.info("Admin in delete page");
        req.getRequestDispatcher("admin/adminPage.jsp").forward(req, resp);
    }
}
