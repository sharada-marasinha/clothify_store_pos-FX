import dao.DaoFactory;
import dao.custom.EmployeeDao;
import dto.EmployeeDto;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class Employee {
    EmployeeDao employeeDao = DaoFactory.getDaoFactory().getDaoType(DaoFactory.DaoType.EMPLOYEE);
    @Test
    public void addEmployee() throws SQLException, ClassNotFoundException {
        employeeDao.save(new EmployeeDto());
    }
}
