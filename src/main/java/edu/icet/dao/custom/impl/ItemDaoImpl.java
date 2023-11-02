package edu.icet.dao.custom.impl;

import edu.icet.dao.custom.ItemDao;
import edu.icet.dto.ItemDto;
import edu.icet.dto.tm.ItemTM;

import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(ItemDto dto) {
        return false;
    }

    @Override
    public boolean update(ItemDto dto, Integer id) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<ItemTM> findAll() {
        return null;
    }

    @Override
    public Integer findLastId() {
        return null;
    }

    @Override
    public ItemDto find(Integer integer) {
        return null;
    }
}
