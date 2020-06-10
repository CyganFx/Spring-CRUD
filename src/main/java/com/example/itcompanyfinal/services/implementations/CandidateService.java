package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.Candidate;
import com.example.itcompanyfinal.model.Employee;
import com.example.itcompanyfinal.repositories.interfaces.MyCrudRepository;
import com.example.itcompanyfinal.services.interfaces.MyCrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService implements MyCrudService<Candidate> {
    private final MyCrudRepository<Candidate> REPOSITORY;

    public CandidateService(@Qualifier("candidateRepository")
                                   MyCrudRepository<Candidate> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public void insert(Candidate candidate) {
         REPOSITORY.insert(candidate);
    }

    @Override
    public List<Candidate> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public Candidate getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }

    @Override
    public void update(Candidate candidate) {
        REPOSITORY.update(candidate);
    }

    @Override
    public void deleteById(int id) throws EmptyResultDataAccessException {
        REPOSITORY.deleteById(id);
    }
}
