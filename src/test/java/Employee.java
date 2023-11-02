import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.EmployeeDao;
import edu.icet.dto.EmployeeDto;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class Employee {
    EmployeeDao employeeDao = DaoFactory.getDaoFactory().getDaoType(DaoFactory.DaoType.EMPLOYEE);
    @Test
    public void addEmployee() throws SQLException, ClassNotFoundException {
        employeeDao.save(new EmployeeDto());
    }
}
