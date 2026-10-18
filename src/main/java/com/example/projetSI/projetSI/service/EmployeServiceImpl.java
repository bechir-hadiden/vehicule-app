package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Employe;
import com.example.projetSI.projetSI.repository.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe retrieveEmploye(Long employeId) {
        return employeRepository.findById(employeId).orElse(null);
    }

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifyEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void removeEmploye(Long employeId) {
        employeRepository.deleteById(employeId);
    }
}
