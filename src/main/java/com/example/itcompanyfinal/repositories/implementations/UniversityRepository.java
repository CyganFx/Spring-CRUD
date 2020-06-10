package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.University;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UniversityRepository implements ReadRepository<University> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private String sqlQuery;

    public UniversityRepository(JdbcTemplate JDBC_TEMPLATE) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
    }

    @Override
    public List<University> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(University.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            University university = new University();
            university.setUniversityId(resultSet.getInt(1));
            university.setUniversityName(resultSet.getString(2));
            university.setUniversityRankWorld(resultSet.getInt(3));
            university.setUniversityRankKZ(resultSet.getInt(4));
            return university;
        });
    }

    @Override
    public University getById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.select(University.TABLE_NAME, University.ID + " = ?", "*");
        return JDBC_TEMPLATE.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(University.class));
    }
}
