package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.Language;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService implements ReadService<Language> {
    private ReadRepository<Language> REPOSITORY;

    public LanguageService(@Qualifier("languageRepository")
                                   ReadRepository<Language> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<Language> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public Language getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }
}
