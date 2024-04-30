package com.ftninformatika.test.controller;

import com.ftninformatika.test.model.Adresa;
import com.ftninformatika.test.service.AdresaService;
import com.ftninformatika.test.support.converters.AdresaConverter;
import com.ftninformatika.test.support.dto.AdresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/adrese", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdresaController {

    @Autowired
    private AdresaService adresaService;

    @Autowired
    private AdresaConverter converter;

    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping()
    public ResponseEntity<List<AdresaDTO>> index(@RequestParam(required = false) Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize) {
        if (pageNo == null) {
            List<Adresa> all = adresaService.findAll();
            return new ResponseEntity<>(converter.toDto(all), HttpStatus.OK);
        }
        Page<Adresa> all = adresaService.findAll(pageNo, pageSize);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(all.getTotalPages()));
        return new ResponseEntity<>(converter.toDto(all.toList()), headers, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<AdresaDTO> findById(@PathVariable Long id) {
        Optional<Adresa> adresa = adresaService.findOne(id);
        if (adresa.isPresent()) return ResponseEntity.ok(converter.toDto(adresa.get()));
        else return ResponseEntity.notFound().build();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<AdresaDTO> create(@RequestBody AdresaDTO dto) {
        Adresa adresa = adresaService.save(converter.toEntity(dto));
        if (adresa != null) return new ResponseEntity<>(converter.toDto(adresa), HttpStatus.CREATED);
        else return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<AdresaDTO> update(@PathVariable Long id, @RequestBody AdresaDTO dto) {
        if (!id.equals(dto.getId())) return ResponseEntity.badRequest().build();

        Adresa adresa = adresaService.save(converter.toEntity(dto));
        if (adresa != null) return new ResponseEntity<>(converter.toDto(adresa), HttpStatus.CREATED);
        else return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Adresa deleted = adresaService.delete(id);
        if (deleted == null) return ResponseEntity.notFound().build();
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}