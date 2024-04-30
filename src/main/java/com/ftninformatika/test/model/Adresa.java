package com.ftninformatika.test.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Adresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ulica;
    @Column(nullable = false)
    private Integer broj;

    @OneToMany(mappedBy = "adresa")
    private List<Trotinet> trotineti;

    public Adresa() {
    }

    public Long getId() {
        return id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    public List<Trotinet> getTrotineti() {
        return trotineti;
    }

    public void setTrotineti(List<Trotinet> trotineti) {
        this.trotineti = trotineti;
    }
}
