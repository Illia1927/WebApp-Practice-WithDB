package mate.academy.webApp.dao.hibernateDao;

import mate.academy.webApp.model.Role;

import java.util.Optional;

public interface RoleDaoHib extends CrudDaoHib<Role> {
    Optional<Role> getByLogin(String name);
}
