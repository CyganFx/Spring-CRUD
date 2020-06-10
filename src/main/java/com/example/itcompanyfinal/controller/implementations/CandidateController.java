package com.example.itcompanyfinal.controller.implementations;

import com.example.itcompanyfinal.additional.SQLSuccessfulQueryMessages;
import com.example.itcompanyfinal.controller.interfaces.MyCrudController;
import com.example.itcompanyfinal.model.Candidate;
import com.example.itcompanyfinal.services.interfaces.MyCrudService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController implements MyCrudController<Candidate> {
    private final MyCrudService<Candidate> SERVICE;

    public CandidateController(MyCrudService<Candidate> SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Override
    @PostMapping("/add")
    public String add(@RequestBody Candidate candidate) {
        SERVICE.insert(candidate);
        return SQLSuccessfulQueryMessages.create(Candidate.class.getSimpleName());
    }

    @Override
    @GetMapping("/all")
    public List<Candidate> showAll() {
        return SERVICE.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Candidate showById(@PathVariable int id) throws EmptyResultDataAccessException {
        try {
            return SERVICE.getById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Such employee doesn't exist, try again" + e.getMessage());
        }
        return SERVICE.getById(id);
    }

    @Override
    @PutMapping("/update")
    public String edit(@RequestBody Candidate candidate) {
        SERVICE.update(candidate);
        return SQLSuccessfulQueryMessages.update(Candidate.class.getSimpleName());
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public String removeById(@PathVariable int id) throws EmptyResultDataAccessException {
        SERVICE.deleteById(id);
        return SQLSuccessfulQueryMessages.delete(Candidate.class.getSimpleName());
    }
}
