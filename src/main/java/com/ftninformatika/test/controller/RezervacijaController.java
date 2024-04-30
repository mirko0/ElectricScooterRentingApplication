package com.ftninformatika.test.controller;

import com.ftninformatika.test.model.Rezervacija;
import com.ftninformatika.test.support.converters.RezervacijaConverter;
import com.ftninformatika.test.support.dto.RezervacijaDTO;
import com.ftninformatika.test.service.RezervacijaService;
import com.ftninformatika.test.support.dto.VratiTrotinetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/rezervacije", produces = MediaType.APPLICATION_JSON_VALUE)
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

    @Autowired
    private RezervacijaConverter converter;

    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping()
    public ResponseEntity<List<RezervacijaDTO>> index(@RequestParam(required = false) Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize) {
        if (pageNo == null) {
            List<Rezervacija> all = rezervacijaService.findAll();
            return new ResponseEntity<>(converter.toDto(all), HttpStatus.OK);
        }
        Page<Rezervacija> all = rezervacijaService.findAll(pageNo, pageSize);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(all.getTotalPages()));
        return new ResponseEntity<>(converter.toDto(all.toList()), headers, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<RezervacijaDTO> findById(@PathVariable Long id) {
        Optional<Rezervacija> rezervacija = rezervacijaService.findOne(id);
        if (rezervacija.isPresent()) return ResponseEntity.ok(converter.toDto(rezervacija.get()));
        else return ResponseEntity.notFound().build();
    }


    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @PostMapping()
    public ResponseEntity<RezervacijaDTO> create(@Validated @RequestBody RezervacijaDTO dto) {
        Rezervacija rezervacija = rezervacijaService.save(converter.toEntity(dto));
        if (rezervacija != null) return new ResponseEntity<>(converter.toDto(rezervacija), HttpStatus.CREATED);
        else return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @PutMapping()
    public ResponseEntity<RezervacijaDTO> returnTrotinet(@Validated @RequestBody VratiTrotinetDTO dto) {
        Rezervacija rezervacija = rezervacijaService.returnAction(dto);

        if (rezervacija != null) return new ResponseEntity<>(converter.toDto(rezervacija), HttpStatus.OK);
        else return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Rezervacija deleted = rezervacijaService.delete(id);
        if (deleted == null) return ResponseEntity.notFound().build();
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}