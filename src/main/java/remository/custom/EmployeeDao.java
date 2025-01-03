package remository.custom;

import remository.CrudDao;
import dto.EmployeeDto;
import dto.tm.EmployeeTM;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface EmployeeDao extends CrudDao<EmployeeDto,Integer> {
    ObservableList<EmployeeTM> findAll() throws SQLException, ClassNotFoundException;
}
