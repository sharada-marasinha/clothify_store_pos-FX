package remository;

import java.sql.SQLException;

public interface CrudDao<T,ID> extends SuperDao {
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto,Integer id) throws SQLException, ClassNotFoundException;
    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    ID findLastId() throws SQLException, ClassNotFoundException;
    T find(ID id) throws SQLException, ClassNotFoundException;
}
