package com.ftninformatika.test.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime vremeIznajmljivanja;

    private LocalDateTime vremeVracanja;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    private Trotinet trotinet;

    public Rezervacija() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getVremeIznajmljivanja() {
        return vremeIznajmljivanja;
    }

    public void setVremeIznajmljivanja(LocalDateTime vremeIznajmljivanja) {
        this.vremeIznajmljivanja = vremeIznajmljivanja;
    }

    public LocalDateTime getVremeVracanja() {
        return vremeVracanja;
    }

    public void setVremeVracanja(LocalDateTime vremeVracanja) {
        this.vremeVracanja = vremeVracanja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Trotinet getTrotinet() {
        return trotinet;
    }

    public void setTrotinet(Trotinet trotinet) {
        this.trotinet = trotinet;
    }
}
