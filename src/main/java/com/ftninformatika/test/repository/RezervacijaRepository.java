package com.ftninformatika.test.repository;

import com.ftninformatika.test.model.Rezervacija;
import com.ftninformatika.test.model.Trotinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {

    Optional<Rezervacija> findOneByEmailAndVremeVracanjaIsNull(String email);

    Optional<Rezervacija> findOneByEmailAndTrotinetAndVremeVracanjaIsNull(String email, Trotinet trotinet);
}
