package edu.icet.dao.custom.impl;

import edu.icet.dao.custom.OrderDetailDao;
import edu.icet.dto.OrderDetailDto;
import edu.icet.dto.tm.OrderDetailTM;

import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public boolean save(OrderDetailDto dto) {
        return false;
    }

    @Override
    public boolean update(OrderDetailDto dto,Integer id) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<OrderDetailTM> findAll() {
        return null;
    }

    @Override
    public Integer findLastId() {
        return null;
    }

    @Override
    public OrderDetailDto find(Integer integer) {
        return null;
    }
}
