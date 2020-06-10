package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.DepartmentManager;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentManagerRepository implements ReadRepository<DepartmentManager> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private final ReadRepository<Department> REPOSITORY;
    private String sqlQuery;

    public DepartmentManagerRepository(JdbcTemplate JDBC_TEMPLATE,
                                       @Qualifier("departmentRepository") ReadRepository<Department> REPOSITORY) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<DepartmentManager> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(DepartmentManager.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            DepartmentManager departmentManager = new DepartmentManager();
            departmentManager.setDepartmentId(resultSet.getInt(1));
            departmentManager.setEmployeeId(resultSet.getInt(2));
            departmentManager.setDepartment(REPOSITORY.getById(resultSet.getInt(1)));
            return departmentManager;
        });
    }

    @Override
    public DepartmentManager getById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.select(DepartmentManager.TABLE_NAME, DepartmentManager.DEPARTMENT_ID + " = ?", "*");
        DepartmentManager departmentManager = JDBC_TEMPLATE.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(DepartmentManager.class));
        departmentManager.setDepartment(REPOSITORY.getById(departmentManager.getDepartmentId()));
        return departmentManager;
    }
}
