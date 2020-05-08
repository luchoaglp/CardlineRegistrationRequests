package com.cardlinesrl.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "abm_cities")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city_name", length = 50, nullable = false)
    private String cityName;

    @Column(name = "city_zip", length = 8, nullable = false)
    private String cityZip;

    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false)
    private Province province;

    public City() {
    }

    public City(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityZip() {
        return cityZip;
    }

    public void setCityZip(String cityZip) {
        this.cityZip = cityZip;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cityZip='" + cityZip + '\'' +
                ", province=" + province +
                '}';
    }
}
