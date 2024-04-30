package com.ftninformatika.test.service;

import com.ftninformatika.test.model.Trotinet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TrotinetService {

    Optional<Trotinet> findOne(Long id);

    List<Trotinet> findAll();

    Page<Trotinet> findAll(int pageNo, int pageSize);

    Trotinet save(Trotinet trotinet);

    Trotinet delete(Long id);

    Page<Trotinet> findAll(Long adresaId, Integer nivoBaterijeOd, Integer nivoBaterijeDo, Integer pageNo, Integer pageSize);

    Trotinet fuelUp(Long id);
}