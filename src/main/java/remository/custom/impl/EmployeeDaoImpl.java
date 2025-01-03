package remository.custom.impl;

import remository.custom.EmployeeDao;
import dto.tm.EmployeeTM;
import dto.EmployeeDto;
import entity.Employee;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import utill.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utill.HibernateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public boolean save(EmployeeDto employee) throws SQLException, ClassNotFoundException {
        System.out.println("Repository : "+employee);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(new ModelMapper().map(employee, Employee.class));
        session.getTransaction().commit();
        session.close();
        return true;
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
    public boolean delete(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();

            // Load the entity to be deleted
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee); // Delete the entity
                session.getTransaction().commit();
                return true;
            } else {
                System.out.println("Employee with ID " + id + " not found.");
                return false;
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public ObservableList<EmployeeTM> findAll(){
        ObservableList<EmployeeTM> list = FXCollections.observableArrayList();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // Retrieve all employees using HQL
        List<Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();

        session.getTransaction().commit();
        session.close();

        // Map Employee entities to EmployeeDto using ModelMapper
        ModelMapper modelMapper = new ModelMapper();
         employeeList.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
         employeeList.forEach(employee -> {
             list.add(modelMapper.map(employee,EmployeeTM.class));
         });
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
