package repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();

    void save(T object);

    void delete(T object);
}
