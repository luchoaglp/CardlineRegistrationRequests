package com.cardlinesrl.domain;

import javax.persistence.*;

@Entity
@Table(name = "RESELLERS")
@DiscriminatorValue("D")
public class Reseller extends Participant {

    /*
    @Column(name = "id_plataforma")
    private Integer plataformaId;
    */

    /*
    @Basic(optional = false)
    @Column(name = "reseller_name")
    private String resellerName;
    */

    public Reseller() { }

    /*
    public Integer getPlataformaId() {
        return plataformaId;
    }

    public void setPlataformaId(Integer plataformaId) {
        this.plataformaId = plataformaId;
    }
    */

    /*
    public String getResellerName() {
        return resellerName;
    }

    public void setResellerName(String resellerName) {
        this.resellerName = resellerName;
    }

    @Override
    public String toString() {
        return "Reseller{" +
                "participantId=" + participantId +
                ", plataformaId=" + plataformaId +
                ", resellerName='" + resellerName + '\'' +
                '}';
    }
    */
}
