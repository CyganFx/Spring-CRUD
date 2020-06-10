package com.example.itcompanyfinal.controller.implementations;

import com.example.itcompanyfinal.controller.interfaces.ReadController;
import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.Office;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController implements ReadController<Office> {
    private final ReadService<Office> SERVICE;

    public OfficeController(ReadService<Office> SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Override
    @GetMapping("/all")
    public List<Office> showAll() {
        return SERVICE.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Office showById(@PathVariable int id) throws EmptyResultDataAccessException {
        return SERVICE.getById(id);
    }
}
