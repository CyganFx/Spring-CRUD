package com.example.itcompanyfinal.controller.implementations;

import com.example.itcompanyfinal.controller.interfaces.ReadController;
import com.example.itcompanyfinal.model.Language;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController implements ReadController<Language> {
    private final ReadService<Language> SERVICE;

    public LanguageController(ReadService<Language> SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Override
    @GetMapping("/all")
    public List<Language> showAll() {
        return SERVICE.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Language showById(@PathVariable int id) throws EmptyResultDataAccessException {
        return SERVICE.getById(id);
    }
}
