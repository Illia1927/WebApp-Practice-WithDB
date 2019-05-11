package mate;

import mate.academy.webApp.dao.GoodDao;
import mate.academy.webApp.dao.impl.GoodDaoImpl;

public class test {
    public static void main(String[] args) {
        GoodDao goodDao = new GoodDaoImpl();
        System.out.println(goodDao.getAllGood());
    }
}
