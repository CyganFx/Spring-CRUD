package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.Salary;
import com.example.itcompanyfinal.model.Status;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaryRepository implements ReadRepository<Salary> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private final ReadRepository<Department> DEPARTMENT_REPOSITORY;
    private final ReadRepository<Status> STATUS_REPOSITORY;
    private String sqlQuery;

    public SalaryRepository(JdbcTemplate JDBC_TEMPLATE,
                            @Qualifier("departmentRepository") ReadRepository<Department> DEPARTMENT_REPOSITORY,
                            @Qualifier("statusRepository") ReadRepository<Status> STATUS_REPOSITORY) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
        this.DEPARTMENT_REPOSITORY = DEPARTMENT_REPOSITORY;
        this.STATUS_REPOSITORY = STATUS_REPOSITORY;
    }

    @Override
    public List<Salary> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(Salary.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            Salary salary = new Salary();
            salary.setEmployeeId(resultSet.getInt(1));
            salary.setDepartmentId(resultSet.getInt(2));
            salary.setStatus_id(resultSet.getInt(3));
            salary.setSalary(resultSet.getInt(4));
            salary.setDepartment(DEPARTMENT_REPOSITORY.getById(resultSet.getInt(2)));
            salary.setStatus(STATUS_REPOSITORY.getById(resultSet.getInt(3)));
            return salary;
        });
    }

    @Override
    public Salary getById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.select(Salary.TABLE_NAME, Salary.EMPLOYEE_ID + " = ?", "*");
        Salary salary = JDBC_TEMPLATE.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Salary.class));
        assert salary != null;
        salary.setDepartment(DEPARTMENT_REPOSITORY.getById(salary.getDepartmentId()));
        salary.setStatus(STATUS_REPOSITORY.getById(salary.getDepartmentId()));
        return salary;
    }
}
