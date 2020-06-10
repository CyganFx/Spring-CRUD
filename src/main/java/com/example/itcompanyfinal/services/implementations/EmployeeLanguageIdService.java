package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.EmployeeLanguageId;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLanguageIdService implements ReadService<EmployeeLanguageId> {
    private final ReadRepository<EmployeeLanguageId> REPOSITORY;

    public EmployeeLanguageIdService(@Qualifier("employeeLanguageIdRepository")
                                             ReadRepository<EmployeeLanguageId> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<EmployeeLanguageId> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public EmployeeLanguageId getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }
}
