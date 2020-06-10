package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.*;
import com.example.itcompanyfinal.repositories.interfaces.MyCrudRepository;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CandidateRepository implements MyCrudRepository<Candidate> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private final ReadRepository<University> UNIVERSITY_REPOSITORY;
    private final ReadRepository<Department> DEPARTMENT_REPOSITORY;
    private String sqlQuery;

    public CandidateRepository(JdbcTemplate JDBC_TEMPLATE,
                               @Qualifier("universityRepository") ReadRepository<University> UNIVERSITY_REPOSITORY,
                               @Qualifier("departmentRepository") ReadRepository<Department> DEPARTMENT_REPOSITORY) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
        this.UNIVERSITY_REPOSITORY = UNIVERSITY_REPOSITORY;
        this.DEPARTMENT_REPOSITORY = DEPARTMENT_REPOSITORY;
    }

    @Override
    public void insert(Candidate candidate) {
        sqlQuery = SQLQueriesShortcutter.insert(Employee.TABLE_NAME, 9);
        JDBC_TEMPLATE.update(sqlQuery, candidate.getCandidateId(), candidate.getBirthDate(),
                candidate.getFirstName(), candidate.getLastName(), candidate.getGender(),
                candidate.getUniversityId(), candidate.getOverallExperience(), candidate.getDepartmentId());
    }

    @Override
    public List<Candidate> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(Candidate.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            Candidate candidate = new Candidate();
            candidate.setCandidateId(resultSet.getInt(1));
            candidate.setBirthDate(resultSet.getDate(2));
            candidate.setFirstName(resultSet.getString(3));
            candidate.setLastName(resultSet.getString(4));
            candidate.setGender(resultSet.getString(5));
            candidate.setUniversityId(resultSet.getInt(6));
            candidate.setOverallExperience(resultSet.getInt(7));
            candidate.setDepartmentId(resultSet.getInt(8));
            candidate.setUniversity(UNIVERSITY_REPOSITORY.getById(resultSet.getInt(6)));
            candidate.setDepartment(DEPARTMENT_REPOSITORY.getById(resultSet.getInt(8)));
            return candidate;
        });
    }

    @Override
    public Candidate getById(int id) {
        sqlQuery = SQLQueriesShortcutter.select(
                Candidate.TABLE_NAME, Candidate.ID + " = ?", "*");
        Candidate candidate = JDBC_TEMPLATE.queryForObject(
                sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Candidate.class));
        assert candidate != null;
        candidate.setUniversity(UNIVERSITY_REPOSITORY.getById(candidate.getUniversityId()));
        candidate.setDepartment(DEPARTMENT_REPOSITORY.getById(candidate.getDepartmentId()));
        return candidate;
    }

    @Override
    public void update(Candidate candidate) {
        sqlQuery = SQLQueriesShortcutter.update(Candidate.TABLE_NAME,
                Candidate.ID + " = ?", Candidate.BIRTH_DATE, Candidate.FIRST_NAME,
                Candidate.LAST_NAME, Candidate.GENDER, Candidate.UNIVERSITY_ID, Candidate.OVERALL_EXPERIENCE,
                Candidate.DEPARTMENT_ID);
        JDBC_TEMPLATE.update(sqlQuery, candidate.getBirthDate(),
                candidate.getFirstName(), candidate.getLastName(), candidate.getGender(),
                candidate.getUniversityId(), candidate.getOverallExperience(), candidate.getDepartmentId(),
                candidate.getCandidateId());
    }

    @Override
    public void deleteById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.delete(
                Candidate.TABLE_NAME, Candidate.ID + " = ?");
        JDBC_TEMPLATE.update(sqlQuery, id);
    }
}
