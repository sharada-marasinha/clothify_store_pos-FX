package edu.icet.dao.custom;

import edu.icet.dao.CrudDao;
import edu.icet.dto.OrderDto;
import edu.icet.dto.tm.ItemTM;
import edu.icet.dto.tm.OrderTM;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao extends CrudDao <OrderDto,Integer> {
    List<OrderTM> findAll() throws SQLException, ClassNotFoundException;
}
