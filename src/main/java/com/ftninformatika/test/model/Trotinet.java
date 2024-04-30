package com.ftninformatika.test.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trotinet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String sifra;

    private Integer nivoBaterije;

    @Column(nullable = false)
    private Integer maksimalnaBrzina;

    @Column(nullable = false)
    private boolean iznajmljen;

    @ManyToOne
    private Adresa adresa;

    @OneToMany(mappedBy = "trotinet")
    private List<Rezervacija> rezervacije;

    public Trotinet() {
    }

    public Long getId() {
        return id;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Integer getNivoBaterije() {
        return nivoBaterije;
    }

    public void setNivoBaterije(Integer nivoBaterije) {
        this.nivoBaterije = nivoBaterije;
    }

    public Integer getMaksimalnaBrzina() {
        return maksimalnaBrzina;
    }

    public void setMaksimalnaBrzina(Integer maksimalnaBrzina) {
        this.maksimalnaBrzina = maksimalnaBrzina;
    }

    public boolean isIznajmljen() {
        return iznajmljen;
    }

    public void setIznajmljen(boolean iznajmljen) {
        this.iznajmljen = iznajmljen;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }
}
