package com.cardlinesrl.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "MERCHANTS_REQUEST")
public class MerchantRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "request_id")
    private Integer requestId;

    @Column(name = "plataforma_id")
    private Integer plataformaId;

    @Column(name = "merchant_request_name", length = 50, nullable = false)
    private String merchantRequestName;

    @Column(name = "real_name", length = 50)
    private String realName;

    @Column(name = "merchant_owner_name", length = 50, nullable = false)
    private String merchantOwnerName;

    @Column(name = "request_type", length = 10, nullable = false)
    private String requestType;

    @Column(name = "merchant_request_phone", length = 30, nullable = false)
    private String merchantRequestPhone;

    @Column(name = "merchant_request_street", length = 70, nullable = false)
    private String merchantRequestStreet;

    @Column(name = "merchant_request_street1", length = 30, nullable = false)
    private String merchantRequestStreet1;

    @Column(name = "merchant_request_street2", length = 30, nullable = false)
    private String merchantRequestStreet2;

    @Column(name = "merchant_request_street_number", length = 30, nullable = false)
    private String merchantRequestStreetNumber;

    @Column(name = "merchant_request_city", length = 50, nullable = false)
    private String merchantRequestCity;

    @Column(name = "merchant_request_province", length = 30, nullable = false)
    private String merchantRequestProvince;

    //@Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$", message = "Email inválido")
    @Column(name = "merchant_request_email", length = 40, nullable = false)
    private String merchantRequestEmail;

    @Size.List ({
            @Size(min = 2, message = "{min} dígitos"),
            @Size(max = 2, message = "{max} dígitos")
    })
    @Column(name = "merchant_request_cuit1", length = 2, nullable = false)
    private String merchantRequestCuit1;

    @Size.List ({
            @Size(min = 7, message = "{min} dígitos"),
            @Size(max = 8, message = "{max} dígitos")
    })
    @Column(name = "merchant_request_cuit2", length = 8, nullable = false)
    private String merchantRequestCuit2;

    @Size.List ({
            @Size(max = 1, message = "{max} dígitos")
    })
    @Column(name = "merchant_request_cuit3", length = 1, nullable = false)
    private String merchantRequestCuit3;

    @Column(name = "merchant_request_device", length = 15, nullable = false)
    private String merchantRequestDevice;

    @Pattern(regexp = "^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$", message = "Latitud inválida")
    @Column(name = "merchant_request_lat", length = 15, nullable = false)
    private String merchantRequestLat;

    @Pattern(regexp = "^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$", message = "Longitud inválida")
    @Column(name = "merchant_request_long", length = 15, nullable = false)
    private String merchantRequestLong;

    @Column(name = "merchant_request_creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date merchantRequestCreationDate;

    @Column(name = "merchant_request_obs")
    private String merchantRequestObs;

    @Column(name = "merchant_request_partido", length = 50)
    private String merchantRequestPartido;

    @Column(name = "merchant_request_barrio", length = 50)
    private String merchantRequestBarrio;

    @Column(name = "merchant_request_comuna", length = 50)
    private String merchantRequestComuna;

    @Column(name = "merchant_request_new", nullable = false)
    private Boolean merchantRequestNew;

    @Column(name = "merchant_request_schedule", length = 1023)
    private String merchantRequestSchedule;

    public MerchantRequest() { }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getPlataformaId() {
        return plataformaId;
    }

    public void setPlataformaId(Integer plataformaId) {
        this.plataformaId = plataformaId;
    }

    public String getMerchantRequestName() {
        return merchantRequestName;
    }

    public void setMerchantRequestName(String merchantRequestName) {
        this.merchantRequestName = merchantRequestName;
    }

    public String getMerchantOwnerName() {
        return merchantOwnerName;
    }

    public void setMerchantOwnerName(String merchantOwnerName) {
        this.merchantOwnerName = merchantOwnerName;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getMerchantRequestPhone() {
        return merchantRequestPhone;
    }

    public void setMerchantRequestPhone(String merchantRequestPhone) {
        this.merchantRequestPhone = merchantRequestPhone;
    }

    public String getMerchantRequestStreet() {
        return merchantRequestStreet;
    }

    public void setMerchantRequestStreet(String merchantRequestStreet) {
        this.merchantRequestStreet = merchantRequestStreet;
    }

    public String getMerchantRequestStreet1() {
        return merchantRequestStreet1;
    }

    public void setMerchantRequestStreet1(String merchantRequestStreet1) {
        this.merchantRequestStreet1 = merchantRequestStreet1;
    }

    public String getMerchantRequestStreet2() {
        return merchantRequestStreet2;
    }

    public void setMerchantRequestStreet2(String merchantRequestStreet2) {
        this.merchantRequestStreet2 = merchantRequestStreet2;
    }

    public String getMerchantRequestStreetNumber() {
        return merchantRequestStreetNumber;
    }

    public void setMerchantRequestStreetNumber(String merchantRequestStreetNumber) {
        this.merchantRequestStreetNumber = merchantRequestStreetNumber;
    }

    public String getMerchantRequestCity() {
        return merchantRequestCity;
    }

    public void setMerchantRequestCity(String merchantRequestCity) {
        this.merchantRequestCity = merchantRequestCity;
    }

    public String getMerchantRequestProvince() {
        return merchantRequestProvince;
    }

    public void setMerchantRequestProvince(String merchantRequestProvince) {
        this.merchantRequestProvince = merchantRequestProvince;
    }

    public String getMerchantRequestEmail() {
        return merchantRequestEmail;
    }

    public void setMerchantRequestEmail(String merchantRequestEmail) {
        this.merchantRequestEmail = merchantRequestEmail;
    }

    public String getMerchantRequestCuit1() {
        return merchantRequestCuit1;
    }

    public void setMerchantRequestCuit1(String merchantRequestCuit1) {
        this.merchantRequestCuit1 = merchantRequestCuit1;
    }

    public String getMerchantRequestCuit2() {
        return merchantRequestCuit2;
    }

    public void setMerchantRequestCuit2(String merchantRequestCuit2) {
        this.merchantRequestCuit2 = merchantRequestCuit2;
    }

    public String getMerchantRequestCuit3() {
        return merchantRequestCuit3;
    }

    public void setMerchantRequestCuit3(String merchantRequestCuit3) {
        this.merchantRequestCuit3 = merchantRequestCuit3;
    }

    public String getMerchantRequestDevice() {
        return merchantRequestDevice;
    }

    public void setMerchantRequestDevice(String merchantRequestDevice) {
        this.merchantRequestDevice = merchantRequestDevice;
    }

    public String getMerchantRequestLat() {
        return merchantRequestLat;
    }

    public void setMerchantRequestLat(String merchantRequestLat) {
        this.merchantRequestLat = merchantRequestLat;
    }

    public String getMerchantRequestLong() {
        return merchantRequestLong;
    }

    public void setMerchantRequestLong(String merchantRequestLong) {
        this.merchantRequestLong = merchantRequestLong;
    }

    public Date getMerchantRequestCreationDate() {
        return merchantRequestCreationDate;
    }

    public void setMerchantRequestCreationDate(Date merchantRequestCreationDate) {
        this.merchantRequestCreationDate = merchantRequestCreationDate;
    }

    public String getMerchantRequestObs() {
        return merchantRequestObs;
    }

    public void setMerchantRequestObs(String merchantRequestObs) {
        this.merchantRequestObs = merchantRequestObs;
    }

    public String getMerchantRequestPartido() {
        return merchantRequestPartido;
    }

    public void setMerchantRequestPartido(String merchantRequestPartido) {
        this.merchantRequestPartido = merchantRequestPartido;
    }

    public String getMerchantRequestBarrio() {
        return merchantRequestBarrio;
    }

    public void setMerchantRequestBarrio(String merchantRequestBarrio) {
        this.merchantRequestBarrio = merchantRequestBarrio;
    }

    public String getMerchantRequestComuna() {
        return merchantRequestComuna;
    }

    public void setMerchantRequestComuna(String merchantRequestComuna) {
        this.merchantRequestComuna = merchantRequestComuna;
    }

    public Boolean getMerchantRequestNew() {
        return merchantRequestNew;
    }

    public void setMerchantRequestNew(Boolean merchantRequestNew) {
        this.merchantRequestNew = merchantRequestNew;
    }

    public String getMerchantRequestSchedule() {
        return merchantRequestSchedule;
    }

    public void setMerchantRequestSchedule(String merchantRequestSchedule) {
        this.merchantRequestSchedule = merchantRequestSchedule;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
