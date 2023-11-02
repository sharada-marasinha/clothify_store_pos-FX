package edu.icet.dao.custom.impl;

import edu.icet.dao.custom.EmployeeDao;
import edu.icet.dto.EmployeeDto;
import edu.icet.dto.tm.EmployeeTM;
import edu.icet.utill.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public boolean save(EmployeeDto employee) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute("INSERT INTO Employer (title, name, nic, dateOfBirth, address, contactNo, bankAccNo, bankBranch)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                employee.getTitle(),
                employee.getName(),
                employee.getNic(),
                employee.getDob(),
                employee.getAddress(),
                employee.getContact(),
                employee.getBankAccountNo(),
                employee.getBankBranch()
        );
    }

    @Override
    public boolean update(EmployeeDto employee,Integer id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Employer set  title=?,name=?,nic=?,dateOfBirth=?,address=?,contactNo=?,bankAccNo=?,bankBranch=? WHERE id=?",
                employee.getTitle(),
                employee.getName(),
                employee.getNic(),
                employee.getDob(),
                employee.getAddress(),
                employee.getContact(),
                employee.getBankAccountNo(),
                employee.getBankBranch(),
                id
        );
    }

    @Override
    public boolean delete(Integer id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Employer WHERE id = ?",id);
    }

    @Override
    public ObservableList<EmployeeTM> findAll() throws SQLException, ClassNotFoundException {
        ObservableList<EmployeeTM> list = FXCollections.observableArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Employer");
        while (rst.next()) {

            list.add(new EmployeeTM(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)
            ));
        }
        return list;
    }

    @Override
    public Integer findLastId() {
        return null;
    }

    @Override
    public EmployeeDto find(Integer integer) throws SQLException, ClassNotFoundException {
      ResultSet rst = CrudUtil.execute("select * from employer where id = ?",integer);
      rst.next();
      return new EmployeeDto(
              rst.getString(2),
              rst.getString(3),
              rst.getString(4),
              rst.getString(5),
              rst.getString(6),
              rst.getString(7),
              rst.getString(8),
              rst.getString(9)
      );
    }
}
