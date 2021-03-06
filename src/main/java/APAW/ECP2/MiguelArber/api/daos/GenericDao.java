package APAW.ECP2.MiguelArber.api.daos;

import java.util.List;

public interface GenericDao<T, ID> {

    void create(T entity);

    T read(ID id);

    void update(T entity);

    T deleteById(ID id);

    List<T> findAll();

}
