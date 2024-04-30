package com.ftninformatika.test.service;

import com.ftninformatika.test.model.Rezervacija;
import com.ftninformatika.test.support.dto.VratiTrotinetDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RezervacijaService {

    Optional<Rezervacija> findOne(Long id);

    List<Rezervacija> findAll();

    Page<Rezervacija> findAll(int pageNo, int pageSize);

    Rezervacija save(Rezervacija rezervacija);

    Rezervacija delete(Long id);

    Rezervacija returnAction(VratiTrotinetDTO dto);
}