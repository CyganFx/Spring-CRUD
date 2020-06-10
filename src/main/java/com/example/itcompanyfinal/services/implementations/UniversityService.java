package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.University;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService implements ReadService<University> {
    private ReadRepository<University> REPOSITORY;

    public UniversityService(@Qualifier("universityRepository")
                                     ReadRepository<University> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<University> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public University getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }
}
