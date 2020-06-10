package com.example.itcompanyfinal.controller.implementations;

import com.example.itcompanyfinal.controller.interfaces.ReadController;
import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.DepartmentManager;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departmentManager")
public class DepartmentManagerController implements ReadController<DepartmentManager> {
    private final ReadService<DepartmentManager> SERVICE;

    public DepartmentManagerController(ReadService<DepartmentManager> SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Override
    @GetMapping("/all")
    public List<DepartmentManager> showAll() {
        return SERVICE.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public DepartmentManager showById(@PathVariable int id) throws EmptyResultDataAccessException {
        return SERVICE.getById(id);
    }
}
