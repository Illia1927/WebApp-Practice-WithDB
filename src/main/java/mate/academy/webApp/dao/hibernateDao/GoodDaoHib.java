package mate.academy.webApp.dao.hibernateDao;

import mate.academy.webApp.model.Good;

public interface GoodDaoHib extends CrudDaoHib<Good> {
    int update(Long id, Good good);

    int delete(Long id);
}
