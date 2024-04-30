package com.ftninformatika.test.service.impl;

import com.ftninformatika.test.model.Adresa;
import com.ftninformatika.test.model.Rezervacija;
import com.ftninformatika.test.model.Trotinet;
import com.ftninformatika.test.repository.AdresaRepository;
import com.ftninformatika.test.repository.RezervacijaRepository;
import com.ftninformatika.test.repository.TrotinetRepository;
import com.ftninformatika.test.service.RezervacijaService;
import com.ftninformatika.test.support.dto.VratiTrotinetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JpaRezervacijaService implements RezervacijaService {

    @Autowired
    private RezervacijaRepository repository;
    @Autowired
    private TrotinetRepository trotinetRepository;

    @Autowired
    private AdresaRepository adresaRepository;

    @Override
    public Optional<Rezervacija> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Rezervacija> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Rezervacija> findAll(int pageNo, int pageSize) {
        return repository.findAll(PageRequest.of(pageNo, pageSize));
    }

    @Override
    public Rezervacija save(Rezervacija rezervacija) {
        if (rezervacija.getId() == null) {
            Rezervacija found = repository.findOneByEmailAndVremeVracanjaIsNull(rezervacija.getEmail()).orElse(null);
            if (found != null) {
                //Isti korisnik pokusava da iznajmi jos jedan trotinet....
                return null;
            }
            rezervacija.setVremeIznajmljivanja(LocalDateTime.now());
            rezervacija.getTrotinet().setIznajmljen(true);
        }else {
            rezervacija.setVremeVracanja(LocalDateTime.now());
            rezervacija.getTrotinet().setIznajmljen(false);
        }
        return repository.save(rezervacija);
    }

    @Override
    public Rezervacija delete(Long id) {
        Rezervacija rezervacija = repository.findById(id).orElse(null);
        if (rezervacija != null) repository.delete(rezervacija);
        return rezervacija;
    }

    @Override
    public Rezervacija returnAction(VratiTrotinetDTO dto) {
        Trotinet trotinet = trotinetRepository.findById(dto.getTrotinetId()).orElse(null);
        if (trotinet == null) return null;
        Adresa adresa = adresaRepository.findById(dto.getAdresaId()).orElse(null);
        if (adresa == null) return null;

        Rezervacija rezervacija = repository.findOneByEmailAndTrotinetAndVremeVracanjaIsNull(dto.getEmail(), trotinet).orElse(null);
        if (rezervacija == null) {
            System.out.println("Nije isti email");
            return null;
        }
        rezervacija.setVremeVracanja(LocalDateTime.now());
        trotinet.setIznajmljen(false);
        trotinet.setAdresa(adresa);
        trotinet.setNivoBaterije(dto.getStanjeBaterije());
        trotinetRepository.save(trotinet);
        return repository.save(rezervacija);
    }
}