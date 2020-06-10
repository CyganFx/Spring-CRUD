package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.*;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeLanguageIdRepository implements ReadRepository<EmployeeLanguageId> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private final ReadRepository<Language> LANGUAGE_REPOSITORY;
    private String sqlQuery;

    public EmployeeLanguageIdRepository(JdbcTemplate JDBC_TEMPLATE,
                                        @Qualifier("languageRepository") ReadRepository<Language> LANGUAGE_REPOSITORY) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
        this.LANGUAGE_REPOSITORY = LANGUAGE_REPOSITORY;
    }

    @Override
    public List<EmployeeLanguageId> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(EmployeeLanguageId.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            EmployeeLanguageId employeeLanguageId = new EmployeeLanguageId();
            employeeLanguageId.setEmployeeId(resultSet.getInt(1));
            employeeLanguageId.setLanguageId(resultSet.getInt(2));
            employeeLanguageId.setLanguage(LANGUAGE_REPOSITORY.getById(resultSet.getInt(2)));
            return employeeLanguageId;
        });
    }

    @Override
    public EmployeeLanguageId getById(int id) throws EmptyResultDataAccessException {
        return null;
    }
}
