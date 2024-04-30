package com.ftninformatika.test.service.impl;

import com.ftninformatika.test.model.Adresa;
import com.ftninformatika.test.repository.AdresaRepository;
import com.ftninformatika.test.service.AdresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaAdresaService implements AdresaService {

    @Autowired
    private AdresaRepository repository;

    @Override
    public Optional<Adresa> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Adresa> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Adresa> findAll(int pageNo, int pageSize) {
        return repository.findAll(PageRequest.of(pageNo, pageSize));
    }

    @Override
    public Adresa save(Adresa adresa) {
        return repository.save(adresa);
    }

    @Override
    public Adresa delete(Long id) {
        Adresa adresa = repository.findById(id).orElse(null);
        if (adresa != null) repository.delete(adresa);
        return adresa;
    }

}