package com.ftninformatika.test.support.dto;

import com.ftninformatika.test.model.Adresa;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TrotinetDTO {

    private Long id;

    @Size(max = 20)
    @NotNull
    private String sifra;

    @Min(value = 0)
    @Max(value = 100)
    private Integer nivoBaterije;

    @NotNull
    private Integer maksimalnaBrzina;

    private boolean iznajmljen;

    private Long adresaId;
    private String adresaUlica;
    private Integer adresaBroj;

    public TrotinetDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Long adresaId) {
        this.adresaId = adresaId;
    }

    public String getAdresaUlica() {
        return adresaUlica;
    }

    public void setAdresaUlica(String adresaUlica) {
        this.adresaUlica = adresaUlica;
    }

    public Integer getAdresaBroj() {
        return adresaBroj;
    }

    public void setAdresaBroj(Integer adresaBroj) {
        this.adresaBroj = adresaBroj;
    }
}
