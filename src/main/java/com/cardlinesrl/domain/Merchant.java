package com.cardlinesrl.domain;

import javax.persistence.*;

@Entity
@Table(name = "MERCHANTS")
@DiscriminatorValue("C")
public class Merchant extends Participant {

    @Column(name = "real_name", length = 50)
    private String realName;

    @Column(name = "merchant_mail", nullable = false)
    private String merchantMail;

    @Column(name = "merchant_cuit", nullable = false)
    private String merchantCuit;

    @Column(name = "merchant_latitud", nullable = false)
    private String merchantLatitud;

    @Column(name = "merchant_longitud", nullable = false)
    private String merchantLongitud;

    @Column(name = "merchant_owner_plataforma")
    private Integer merchantOwnerId;

    @Column(name = "merchant_street", length = 70, nullable = false)
    private String merchantStreet;

    @Column(name = "merchant_address1", length = 30, nullable = false)
    private String merchantAddress1;

    @Column(name = "merchant_address2", length = 30, nullable = false)
    private String merchantAddress2;

    @Column(name = "merchant_number", nullable = false)
    private String merchantNumber;

    @Column(name = "merchant_country", nullable = false)
    private String merchantCountry;

    @Column(name = "merchant_sube", nullable = false)
    private Boolean merchantSube;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public Merchant() { }

    public String getMerchantMail() {
        return merchantMail;
    }

    public void setMerchantMail(String merchantMail) {
        this.merchantMail = merchantMail;
    }

    public String getMerchantCuit() {
        return merchantCuit;
    }

    public void setMerchantCuit(String merchantCuit) {
        this.merchantCuit = merchantCuit;
    }

    public String getMerchantLatitud() {
        return merchantLatitud;
    }

    public void setMerchantLatitud(String merchantLatitud) {
        this.merchantLatitud = merchantLatitud;
    }

    public String getMerchantLongitud() {
        return merchantLongitud;
    }

    public void setMerchantLongitud(String merchantLongitud) {
        this.merchantLongitud = merchantLongitud;
    }

    public Integer getMerchantOwnerId() {
        return merchantOwnerId;
    }

    public void setMerchantOwnerId(Integer merchantOwnerId) {
        this.merchantOwnerId = merchantOwnerId;
    }

    public String getMerchantStreet() {
        return merchantStreet;
    }

    public void setMerchantStreet(String merchantStreet) {
        this.merchantStreet = merchantStreet;
    }

    public String getMerchantAddress1() {
        return merchantAddress1;
    }

    public void setMerchantAddress1(String merchantAddress1) {
        this.merchantAddress1 = merchantAddress1;
    }

    public String getMerchantAddress2() {
        return merchantAddress2;
    }

    public void setMerchantAddress2(String merchantAddress2) {
        this.merchantAddress2 = merchantAddress2;
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public String getMerchantCountry() {
        return merchantCountry;
    }

    public void setMerchantCountry(String merchantCountry) {
        this.merchantCountry = merchantCountry;
    }

    public Boolean getMerchantSube() {
        return merchantSube;
    }

    public void setMerchantSube(Boolean merchantSube) {
        this.merchantSube = merchantSube;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "participantId=" + participantId +
                ", merchantMail='" + merchantMail + '\'' +
                ", merchantCuit='" + merchantCuit + '\'' +
                ", merchantLatitud='" + merchantLatitud + '\'' +
                ", merchantLongitud='" + merchantLongitud + '\'' +
                ", merchantOwnerId=" + merchantOwnerId +
                ", merchantStreet='" + merchantStreet + '\'' +
                ", merchantAddress1='" + merchantAddress1 + '\'' +
                ", merchantAddress2='" + merchantAddress2 + '\'' +
                ", merchantNumber='" + merchantNumber + '\'' +
                ", merchantCountry='" + merchantCountry + '\'' +
                ", city=" + city +
                '}';
    }
}
