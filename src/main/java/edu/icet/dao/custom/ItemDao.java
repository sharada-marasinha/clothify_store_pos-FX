package edu.icet.dao.custom;

import edu.icet.dao.CrudDao;
import edu.icet.dto.ItemDto;
import edu.icet.dto.tm.EmployeeTM;
import edu.icet.dto.tm.ItemTM;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao extends CrudDao<ItemDto,Integer> {
    List<ItemTM> findAll() throws SQLException, ClassNotFoundException;
}
