package com.ftninformatika.test.support.dto;

import com.ftninformatika.test.model.Trotinet;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RezervacijaDTO {

    private Long id;

    private String vremeIznajmljivanja;

    private String vremeVracanja;

    @NotNull
    @Email
    private String email;

    @NotNull
    private Long trotinetId;


    public RezervacijaDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVremeIznajmljivanja() {
        if (vremeIznajmljivanja == null) return null;
        return LocalDateTime.parse(vremeIznajmljivanja);
    }

    public void setVremeIznajmljivanja(LocalDateTime vremeIznajmljivanja) {
        if (vremeIznajmljivanja == null) this.vremeIznajmljivanja = null;
        else
            this.vremeIznajmljivanja = vremeIznajmljivanja.toString();
    }

    public LocalDateTime getVremeVracanja() {
        if (vremeVracanja == null) return null;
        return LocalDateTime.parse(vremeVracanja);
    }

    public void setVremeVracanja(LocalDateTime vremeVracanja) {
        if (vremeVracanja == null) this.vremeVracanja = null;
        else
            this.vremeVracanja = vremeVracanja.toString();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTrotinetId() {
        return trotinetId;
    }

    public void setTrotinetId(Long trotinetId) {
        this.trotinetId = trotinetId;
    }
}
