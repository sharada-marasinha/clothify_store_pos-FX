package edu.icet.dao;

import java.util.List;

public interface CrudDao<T,ID> extends SuperDao {
    boolean save(T dto);
    boolean update(T dto);
    boolean delete(ID id);
    List<T> findAll();
    ID findLastId();
    T find(ID id);
}
