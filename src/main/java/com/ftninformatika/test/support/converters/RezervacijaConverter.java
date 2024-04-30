package com.ftninformatika.test.support.converters;

import com.ftninformatika.test.model.Rezervacija;
import com.ftninformatika.test.model.Trotinet;
import com.ftninformatika.test.repository.TrotinetRepository;
import com.ftninformatika.test.support.dto.RezervacijaDTO;
import com.ftninformatika.test.repository.RezervacijaRepository;
import com.ftninformatika.test.support.TwoWayConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RezervacijaConverter extends TwoWayConverter<Rezervacija, RezervacijaDTO> {

    @Autowired
    private RezervacijaRepository repository;
    @Autowired
    private TrotinetRepository trotinetRepository;

    @Override
    public RezervacijaDTO toDto(Rezervacija source) {
        RezervacijaDTO dto = new RezervacijaDTO();
        dto.setId(source.getId());

        dto.setEmail(source.getEmail());
        dto.setTrotinetId(source.getTrotinet().getId());

        dto.setVremeIznajmljivanja(source.getVremeIznajmljivanja());
        dto.setVremeVracanja(source.getVremeVracanja());

        return dto;
    }

    @Override
    public Rezervacija toEntity(RezervacijaDTO target) {
        Rezervacija rezervacija = null;
        if (target.getId() != null) rezervacija = repository.findById(target.getId()).orElse(null);
        if (rezervacija == null) rezervacija = new Rezervacija();

        if (target.getEmail() != null) {
            rezervacija.setEmail(target.getEmail());
        }
        if (target.getVremeVracanja() != null) rezervacija.setVremeVracanja(target.getVremeVracanja());
        if (target.getVremeIznajmljivanja() != null) rezervacija.setVremeIznajmljivanja(target.getVremeIznajmljivanja());
        if (target.getTrotinetId() != null) {
            Trotinet trotinet = trotinetRepository.findById(target.getTrotinetId()).orElse(null);
            if (trotinet != null) rezervacija.setTrotinet(trotinet);
        }

        return rezervacija;
    }

}