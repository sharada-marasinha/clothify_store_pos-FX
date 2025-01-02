package dao.custom;

import dao.CrudDao;
import dto.ItemDto;
import dto.tm.ItemTM;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao extends CrudDao<ItemDto,Integer> {
    List<ItemTM> findAll() throws SQLException, ClassNotFoundException;
}
