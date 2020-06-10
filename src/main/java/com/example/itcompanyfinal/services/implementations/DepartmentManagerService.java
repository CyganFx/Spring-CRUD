package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.DepartmentManager;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManagerService implements ReadService<DepartmentManager> {
    private ReadRepository<DepartmentManager> REPOSITORY;

    public DepartmentManagerService(@Qualifier("departmentManagerRepository")
                                     ReadRepository<DepartmentManager> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<DepartmentManager> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public DepartmentManager getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }
}
