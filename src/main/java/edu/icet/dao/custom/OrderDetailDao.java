package edu.icet.dao.custom;

import edu.icet.dao.CrudDao;
import edu.icet.dto.OrderDetailDto;
import edu.icet.dto.tm.ItemTM;
import edu.icet.dto.tm.OrderDetailTM;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDao extends CrudDao<OrderDetailDto,Integer> {
    List<OrderDetailTM> findAll() throws SQLException, ClassNotFoundException;
}
