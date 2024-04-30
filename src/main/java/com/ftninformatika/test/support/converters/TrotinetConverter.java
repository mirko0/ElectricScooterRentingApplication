package com.ftninformatika.test.support.converters;

import com.ftninformatika.test.model.Adresa;
import com.ftninformatika.test.model.Trotinet;
import com.ftninformatika.test.repository.AdresaRepository;
import com.ftninformatika.test.repository.TrotinetRepository;
import com.ftninformatika.test.support.TwoWayConverter;
import com.ftninformatika.test.support.dto.TrotinetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrotinetConverter extends TwoWayConverter<Trotinet, TrotinetDTO> {

    @Autowired
    private TrotinetRepository repository;
    @Autowired
    private AdresaRepository adresaRepository;

    @Override
    public TrotinetDTO toDto(Trotinet source) {
        TrotinetDTO dto = new TrotinetDTO();
        dto.setId(source.getId());

        if (source.getAdresa() != null) {
            dto.setAdresaBroj(source.getAdresa().getBroj());
            dto.setAdresaUlica(source.getAdresa().getUlica());
            dto.setAdresaId(source.getAdresa().getId());
        }

        dto.setIznajmljen(source.isIznajmljen());
        dto.setMaksimalnaBrzina(source.getMaksimalnaBrzina());
        dto.setNivoBaterije(source.getNivoBaterije());
        dto.setSifra(source.getSifra());

        return dto;
    }

    @Override
    public Trotinet toEntity(TrotinetDTO target) {
        Trotinet trotinet = null;
        if (target.getId() != null) trotinet = repository.findById(target.getId()).orElse(null);
        if (trotinet == null) trotinet = new Trotinet();

        if (target.getAdresaId() != null) {
            Adresa adresa = adresaRepository.findById(target.getAdresaId()).orElse(null);
            if (adresa != null) trotinet.setAdresa(adresa);
        }

        if (target.getSifra() != null) {
            trotinet.setSifra(target.getSifra());
        }

        if (target.getMaksimalnaBrzina() != null) {
            trotinet.setMaksimalnaBrzina(target.getMaksimalnaBrzina());
        }

/*        if (target.getNivoBaterije() != null) {
            trotinet.setNivoBaterije(target.getNivoBaterije());
        }*/

        return trotinet;
    }

}