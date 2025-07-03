package com.example.demo.service;

import com.example.demo.entity.National;
import com.example.demo.repository.NationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationalService {

    @Autowired
    private NationalRepository nationalRepository;

    public List<National> getAllNationals() {
        return nationalRepository.findAll();
    }

    public National saveNational(National national) {
        return nationalRepository.save(national);
    }

    public void deleteNational(Integer id) {
        nationalRepository.deleteById(id);
    }

    public Optional<National> getNationalById(Integer id) {
        return nationalRepository.findById(id);
    }
}
