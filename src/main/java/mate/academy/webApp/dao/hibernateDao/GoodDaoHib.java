package mate.academy.webApp.dao.hibernateDao;

import mate.academy.webApp.model.Good;

public interface GoodDaoHib extends CrudDao<Good, Long> {
    int update(Long id, Good good);
}
