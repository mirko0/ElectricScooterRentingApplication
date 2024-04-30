package com.ftninformatika.test.service.impl;

import com.ftninformatika.test.model.Trotinet;
import com.ftninformatika.test.repository.TrotinetRepository;
import com.ftninformatika.test.service.TrotinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaTrotinetService implements TrotinetService {

    @Autowired
    private TrotinetRepository repository;

    @Override
    public Optional<Trotinet> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Trotinet> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Trotinet> findAll(int pageNo, int pageSize) {
        return repository.findAll(PageRequest.of(pageNo, pageSize));
    }

    @Override
    public Trotinet save(Trotinet trotinet) {
        // ako je nov
        if (trotinet.getId() == null) {
            trotinet.setNivoBaterije(100);
            trotinet.setIznajmljen(false);
        }
        return repository.save(trotinet);
    }

    @Override
    public Trotinet delete(Long id) {
        Trotinet trotinet = repository.findById(id).orElse(null);
        if (trotinet != null) repository.delete(trotinet);
        return trotinet;
    }

    @Override
    public Page<Trotinet> findAll(Long adresaId, Integer nivoBaterijeOd, Integer nivoBaterijeDo, Integer pageNo, Integer pageSize) {
        return repository.search(adresaId, nivoBaterijeOd, nivoBaterijeDo, PageRequest.of(pageNo, pageSize));
    }

    @Override
    public Trotinet fuelUp(Long id) {
        Trotinet trotinet = repository.findById(id).orElse(null);
        if (trotinet != null) {
            if (trotinet.isIznajmljen()) return null;

            trotinet.setNivoBaterije(100);
            repository.save(trotinet);
        }

        return trotinet;
    }
}