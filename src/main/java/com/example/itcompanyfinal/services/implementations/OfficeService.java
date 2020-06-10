package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.Office;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService implements ReadService<Office> {
    private ReadRepository<Office> REPOSITORY;

    public OfficeService(@Qualifier("officeRepository")
                                     ReadRepository<Office> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<Office> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public Office getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }
}
