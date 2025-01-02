package dao.custom;

import dao.CrudDao;
import dto.OrderDetailDto;
import dto.tm.OrderDetailTM;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDao extends CrudDao<OrderDetailDto,Integer> {
    List<OrderDetailTM> findAll() throws SQLException, ClassNotFoundException;
}
