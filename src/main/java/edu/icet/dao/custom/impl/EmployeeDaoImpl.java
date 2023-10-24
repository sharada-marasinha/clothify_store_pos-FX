package edu.icet.dao.custom.impl;

import edu.icet.dao.custom.EmployeeDao;
import edu.icet.dto.EmployeeDto;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public boolean save(EmployeeDto dto) {
        return false;
    }

    @Override
    public boolean update(EmployeeDto dto) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<EmployeeDto> findAll() {
        return null;
    }

    @Override
    public Integer findLastId() {
        return null;
    }

    @Override
    public EmployeeDto find(Integer integer) {
        return null;
    }
}
