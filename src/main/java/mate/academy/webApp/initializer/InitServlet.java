package mate.academy.webApp.initializer;

import mate.academy.webApp.dao.hibernateDao.GoodDaoHib;
import mate.academy.webApp.dao.hibernateDao.OrderDaoHib;
import mate.academy.webApp.dao.hibernateDao.RoleDaoHib;
import mate.academy.webApp.dao.hibernateDao.UserDaoHib;
import mate.academy.webApp.dao.hibernateDao.impl.GoodDaoHibImpl;
import mate.academy.webApp.dao.hibernateDao.impl.OrderDaoHibImpl;
import mate.academy.webApp.dao.hibernateDao.impl.RoleDaoHibImpl;
import mate.academy.webApp.dao.hibernateDao.impl.UserDaoHibImpl;
import mate.academy.webApp.model.Good;
import mate.academy.webApp.model.Order;
import mate.academy.webApp.model.Role;
import mate.academy.webApp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InitServlet", urlPatterns = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        RoleDaoHib roleDaoHib = new RoleDaoHibImpl();
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        roleDaoHib.add(roleAdmin);
        roleDaoHib.add(roleUser);

        UserDaoHib userDaoHib = new UserDaoHibImpl();
        User admin = new User("admin", "admin", "wides544@gmail.com", "admin", roleAdmin);
        User user = new User("Illia", "Ilya", "wides544@gmail.com", "edcwsxqaz", roleUser);
        userDaoHib.add(admin);
        userDaoHib.add(user);

        GoodDaoHib goodDaoHib = new GoodDaoHibImpl();
        Good firstGood = new Good("Samsung", "Galaxy S7 EDGE", 9999D);
        Good secondGood = new Good("Iphone", "8 PLUS", 14000D);
        goodDaoHib.add(firstGood);
        goodDaoHib.add(secondGood);

        List<Good> goods = new ArrayList<>();
        goods.add(firstGood);
        goods.add(secondGood);
        Order orderOne = new Order(goods, admin);
        OrderDaoHib orderDaoHib = new OrderDaoHibImpl();
        orderDaoHib.add(orderOne);
        System.out.println(orderDaoHib.getAll(Order.class));
    }
}
