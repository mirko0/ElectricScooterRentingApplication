package com.ftninformatika.test.support.converters;

import com.ftninformatika.test.model.Adresa;
import com.ftninformatika.test.model.Trotinet;
import com.ftninformatika.test.repository.TrotinetRepository;
import com.ftninformatika.test.support.dto.AdresaDTO;
import com.ftninformatika.test.repository.AdresaRepository;
import com.ftninformatika.test.support.TwoWayConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AdresaConverter extends TwoWayConverter<Adresa, AdresaDTO> {

    @Autowired
    private AdresaRepository repository;

    @Autowired
    private TrotinetRepository trotinetRepository;

    @Override
    public AdresaDTO toDto(Adresa source) {
        AdresaDTO dto = new AdresaDTO();
        dto.setId(source.getId());

        dto.setUlica(source.getUlica());
        dto.setBroj(source.getBroj());
        dto.setTrotineti(new ArrayList<>());
        for (Trotinet trotinet : source.getTrotineti()) {
            dto.getTrotineti().add(trotinet.getId());
        }

        return dto;
    }

    @Override
    public Adresa toEntity(AdresaDTO target) {
        Adresa adresa = null;
        if (target.getId() != null) adresa = repository.findById(target.getId()).orElse(null);
        if (adresa == null) adresa = new Adresa();

        if (target.getUlica() != null) {
            adresa.setUlica(target.getUlica());
        }

        if (target.getBroj() != null) adresa.setBroj(target.getBroj());
        adresa.setTrotineti(new ArrayList<>());
        if (target.getTrotineti() != null) {
            for (Long id : target.getTrotineti()) {
                Trotinet trotinet = trotinetRepository.findById(id).orElse(null);
                if (trotinet != null) adresa.getTrotineti().add(trotinet);
            }
        }

        return adresa;
    }

}