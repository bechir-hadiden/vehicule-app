package com.example.projetSI.projetSI.service;

import com.example.projetSI.projetSI.domain.Employe;
import java.util.List;

public interface IEmployeService {
    List<Employe> retrieveAllEmployes();
    Employe retrieveEmploye(Long employeId);
    Employe addEmploye(Employe employe);
    Employe modifyEmploye(Employe employe);
    void removeEmploye(Long employeId);
}
