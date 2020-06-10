package com.example.itcompanyfinal.controller.implementations;

import com.example.itcompanyfinal.controller.interfaces.ReadController;

import com.example.itcompanyfinal.model.University;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController implements ReadController<University> {
    private final ReadService<University> SERVICE;

    public UniversityController(ReadService<University> SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Override
    @GetMapping("/all")
    public List<University> showAll() {
        return SERVICE.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public University showById(@PathVariable int id) throws EmptyResultDataAccessException {
        return SERVICE.getById(id);
    }
}
