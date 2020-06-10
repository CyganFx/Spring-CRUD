package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.Language;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageRepository implements ReadRepository<Language> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private String sqlQuery;

    public LanguageRepository(JdbcTemplate JDBC_TEMPLATE) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
    }

    @Override
    public List<Language> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(Language.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            Language language = new Language();
            language.setLanguageId(resultSet.getInt(1));
            language.setLanguageName(resultSet.getString(2));
            return language;
        });
    }

    @Override
    public Language getById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.select(Language.TABLE_NAME, Language.ID + " = ?", "*");
        return JDBC_TEMPLATE.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Language.class));
    }
}
