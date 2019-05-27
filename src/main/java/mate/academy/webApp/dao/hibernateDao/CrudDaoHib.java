package mate.academy.webApp.dao.hibernateDao;

import java.util.List;

public interface CrudDaoHib<T> {
    void add(T entity);

    T getById(Class<T> clazz, Long id);

    List<T> getAll(Class<T> clazz);

    void update(T entity);

    void delete(T entity);
    
}
