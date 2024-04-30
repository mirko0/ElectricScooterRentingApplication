package com.ftninformatika.test.support.dto;
import java.util.List;

public class AdresaDTO {

    private Long id;
    private String ulica;
    private Integer broj;
    private List<Long> trotineti;

    public AdresaDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getTrotineti() {
        return trotineti;
    }

    public void setTrotineti(List<Long> trotineti) {
        this.trotineti = trotineti;
    }
}
