package mate.academy.webApp.servlet.order;

import mate.academy.webApp.dao.hibernateDao.GoodDaoHib;
import mate.academy.webApp.dao.hibernateDao.OrderDaoHib;
import mate.academy.webApp.dao.hibernateDao.UserDaoHib;
import mate.academy.webApp.dao.hibernateDao.impl.GoodDaoHibImpl;
import mate.academy.webApp.dao.hibernateDao.impl.OrderDaoHibImpl;
import mate.academy.webApp.dao.hibernateDao.impl.UserDaoHibImpl;
import mate.academy.webApp.model.Good;
import mate.academy.webApp.model.Order;
import mate.academy.webApp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/addToOrder")
public class AddToOrderServlet extends HttpServlet {

    private static final GoodDaoHib goodDao = new GoodDaoHibImpl();
    private static final OrderDaoHib orderDao = new OrderDaoHibImpl();
    private static final UserDaoHib userDao = new UserDaoHibImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long goodId = Long.valueOf(req.getParameter("goodId"));
        Good good = goodDao.getById(Good.class, goodId);
        User userFromSession = (User) req.getSession().getAttribute("user");
        User userFromDb = userDao.getById(User.class, userFromSession.getUserId());
        Order userOrder = userFromDb.getOrder();
        if(userOrder == null){
            Order order = new Order(Arrays.asList(good), userFromDb);
            orderDao.add(order);
        }else {
            userOrder.getGoods().add(good);
            orderDao.update(userOrder);
        }
    }
}
