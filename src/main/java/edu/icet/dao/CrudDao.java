package edu.icet.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T,ID> extends SuperDao {
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    ID findLastId() throws SQLException, ClassNotFoundException;
    T find(ID id) throws SQLException, ClassNotFoundException;
}
