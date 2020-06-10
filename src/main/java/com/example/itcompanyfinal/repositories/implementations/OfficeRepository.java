package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.Office;
import com.example.itcompanyfinal.model.Status;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfficeRepository implements ReadRepository<Office> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private final ReadRepository<Status> STATUS_REPOSITORY;
    private String sqlQuery;

    public OfficeRepository(JdbcTemplate JDBC_TEMPLATE,
                            @Qualifier("statusRepository") ReadRepository<Status> STATUS_REPOSITORY) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
        this.STATUS_REPOSITORY = STATUS_REPOSITORY;
    }

    @Override
    public List<Office> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(Office.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            Office office = new Office();
            office.setEmployeeId(resultSet.getInt(1));
            office.setStatusId(resultSet.getInt(2));
            office.setOfficeRoom(resultSet.getInt(3));
            office.setStatus(STATUS_REPOSITORY.getById(resultSet.getInt(2)));
            return office;
        });
    }

    @Override
    public Office getById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.select(Office.TABLE_NAME, Office.OFFICE_ROOM + " = ?", "*");
        Office office = JDBC_TEMPLATE.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Office.class));
        assert office != null;
        office.setStatus(STATUS_REPOSITORY.getById(office.getStatusId()));
        return office;
    }
}
