package com.ftninformatika.test.service;

import com.ftninformatika.test.model.Adresa;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AdresaService {

    Optional<Adresa> findOne(Long id);

    List<Adresa> findAll();

    Page<Adresa> findAll(int pageNo, int pageSize);

    Adresa save(Adresa adresa);

    Adresa delete(Long id);

}