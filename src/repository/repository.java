package repository;

import java.util.List;

public interface repository<T> {

    T findOne(String key);
    List<T> findAll();
    T create(T object);
    void delete(String key);
    T update(String key, T object);

}
