package mate.academy.webApp.dao.hibernateDao;

import mate.academy.webApp.model.User;

import java.util.Optional;

public interface UserDaoHib extends CrudDaoHib<User>{
    Optional<User> getByLogin(String login);

    int delete(Long id);
}
