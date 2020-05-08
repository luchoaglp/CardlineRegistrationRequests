package com.cardlinesrl.domain;

import javax.persistence.*;

@Entity
@Table(name = "RESELLERS")
@DiscriminatorValue("D")
public class Reseller extends Participant {

    @Column(name = "reseller_sube", nullable = false)
    private Boolean resellerSube;

    public Reseller() { }

    public Boolean getResellerSube() {
        return resellerSube;
    }

    public void setResellerSube(Boolean resellerSube) {
        this.resellerSube = resellerSube;
    }
}
