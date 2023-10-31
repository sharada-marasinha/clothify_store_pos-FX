package edu.icet.dao.custom;

import edu.icet.dao.CrudDao;
import edu.icet.dto.EmployeeDto;
import edu.icet.dto.tm.EmployeeTM;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao extends CrudDao<EmployeeDto,Integer> {
    ObservableList<EmployeeTM> findAll() throws SQLException, ClassNotFoundException;
}
