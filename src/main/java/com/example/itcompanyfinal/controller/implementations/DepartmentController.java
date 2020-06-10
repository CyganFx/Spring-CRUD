package com.example.itcompanyfinal.controller.implementations;

import com.example.itcompanyfinal.controller.interfaces.ReadController;
import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController implements ReadController<Department> {
    private final ReadService<Department> SERVICE;

    public DepartmentController(ReadService<Department> SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Override
    @GetMapping("/all")
    public List<Department> showAll() {
        return SERVICE.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Department showById(@PathVariable int id) throws EmptyResultDataAccessException {
        return SERVICE.getById(id);
    }
}
