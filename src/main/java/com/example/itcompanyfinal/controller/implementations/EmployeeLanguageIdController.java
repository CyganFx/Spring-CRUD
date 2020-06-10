package com.example.itcompanyfinal.controller.implementations;

import com.example.itcompanyfinal.controller.interfaces.ReadController;
import com.example.itcompanyfinal.model.EmployeeLanguageId;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeLanguageIdController implements ReadController<EmployeeLanguageId> {
    private final ReadService<EmployeeLanguageId> SERVICE;

    public EmployeeLanguageIdController(ReadService<EmployeeLanguageId> SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Override
    @GetMapping("/all/language")
    public List<EmployeeLanguageId> showAll() {
        return SERVICE.getAll();
    }

    @Override
    public EmployeeLanguageId showById(int id) throws EmptyResultDataAccessException {
        return null;
    }
}
