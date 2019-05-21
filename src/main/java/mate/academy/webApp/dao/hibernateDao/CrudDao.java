package mate.academy.webApp.dao.hibernateDao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDao<T, ID extends Serializable> {
    Long add(T entity);

    Optional<T> getById(ID id);

    Optional<T> getByLogin(String entity);

    List<T> getAll();

    int update(T entity);

    int delete(ID id);
}
