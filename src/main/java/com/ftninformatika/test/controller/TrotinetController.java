package com.ftninformatika.test.controller;

import com.ftninformatika.test.model.Trotinet;
import com.ftninformatika.test.support.converters.TrotinetConverter;
import com.ftninformatika.test.service.TrotinetService;
import com.ftninformatika.test.support.dto.TrotinetDTO;
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
@RequestMapping(value = "/api/trotineti", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrotinetController {

    @Autowired
    private TrotinetService trotinetService;

    @Autowired
    private TrotinetConverter converter;

    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping()
    public ResponseEntity<List<TrotinetDTO>> index(
            @RequestParam(required = false) Long adresaId,
            @RequestParam(required = false) Integer nivoBaterijeOd,
            @RequestParam(required = false) Integer nivoBaterijeDo,
            @RequestParam(required = false) Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize) {
        if (pageNo == null) {
            List<Trotinet> all = trotinetService.findAll();
            return new ResponseEntity<>(converter.toDto(all), HttpStatus.OK);
        }
        Page<Trotinet> all = trotinetService.findAll(adresaId, nivoBaterijeOd, nivoBaterijeDo, pageNo, pageSize);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(all.getTotalPages()));
        return new ResponseEntity<>(converter.toDto(all.toList()), headers, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TrotinetDTO> findById(@PathVariable Long id) {
        Optional<Trotinet> trotinet = trotinetService.findOne(id);
        if (trotinet.isPresent()) return ResponseEntity.ok(converter.toDto(trotinet.get()));
        else return ResponseEntity.notFound().build();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<TrotinetDTO> create(@Validated @RequestBody TrotinetDTO dto) {
        Trotinet trotinet = trotinetService.save(converter.toEntity(dto));
        if (trotinet != null) return new ResponseEntity<>(converter.toDto(trotinet), HttpStatus.CREATED);
        else return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/fuelup")
    public ResponseEntity<TrotinetDTO> fuelUp(@PathVariable Long id) {
        Trotinet trotinet = trotinetService.fuelUp(id);
        if (trotinet != null) return new ResponseEntity<>(converter.toDto(trotinet), HttpStatus.OK);
        else return ResponseEntity.badRequest().build();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TrotinetDTO> update(@PathVariable Long id, @Validated @RequestBody TrotinetDTO dto) {
        if (!id.equals(dto.getId())) return ResponseEntity.badRequest().build();

        Trotinet trotinet = trotinetService.save(converter.toEntity(dto));
        if (trotinet != null) return new ResponseEntity<>(converter.toDto(trotinet), HttpStatus.CREATED);
        else return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Trotinet deleted = trotinetService.delete(id);
        if (deleted == null) return ResponseEntity.notFound().build();
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}