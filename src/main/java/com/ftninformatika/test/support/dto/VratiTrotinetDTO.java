package com.ftninformatika.test.support.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class VratiTrotinetDTO {

    @NotNull
    private String email;

    @NotNull
    private Long adresaId;
    @NotNull
    @Positive
    private Integer stanjeBaterije;

    @NotNull
    private Long trotinetId;

    public VratiTrotinetDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(Long adresaId) {
        this.adresaId = adresaId;
    }

    public Integer getStanjeBaterije() {
        return stanjeBaterije;
    }

    public void setStanjeBaterije(Integer stanjeBaterije) {
        this.stanjeBaterije = stanjeBaterije;
    }

    public Long getTrotinetId() {
        return trotinetId;
    }

    public void setTrotinetId(Long trotinetId) {
        this.trotinetId = trotinetId;
    }
}
