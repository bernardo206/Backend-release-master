package org.example.service;

import org.example.repository.DentistRepository;
import org.example.model.Dentist;

import java.util.List;

public class DentistService {

    private final DentistRepository<Dentist> dentistRepository;

    public DentistService(DentistRepository<Dentist> dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public Dentist save(Dentist dentist){
        return dentistRepository.save(dentist);
    }
    public Dentist findById(int id){
        return dentistRepository.findById(id);
    }
    public List<Dentist> findAll(){
        return dentistRepository.findAll();
    }
    public void deleteById(int id){
        dentistRepository.deleteById(id);
    }


    public void deleteAll(){
        dentistRepository.deleteAll();
    }
}

