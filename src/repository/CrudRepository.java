package repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();

    T findById(int id);

    void save(T object);

    void delete(T object);
}
