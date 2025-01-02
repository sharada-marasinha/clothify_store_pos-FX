package dao.custom;

import dao.CrudDao;
import dto.OrderDto;
import dto.tm.OrderTM;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao extends CrudDao<OrderDto,Integer> {
    List<OrderTM> findAll() throws SQLException, ClassNotFoundException;
}
