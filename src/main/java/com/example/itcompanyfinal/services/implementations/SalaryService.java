package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.Salary;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService implements ReadService<Salary> {
    private ReadRepository<Salary> REPOSITORY;

    public SalaryService(@Qualifier("salaryRepository")
                                     ReadRepository<Salary> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<Salary> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public Salary getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }
}
