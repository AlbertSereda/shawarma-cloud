package com.spring.shawarma.shawarmacloud;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ShawarmaOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Delivery name is required")
    public String deliveryName;

    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List<Shawarma> shawarmas = new ArrayList<>();

    public ShawarmaOrder(Long id, Date placedAt, String deliveryName, String deliveryStreet, String deliveryCity, String deliveryState, String deliveryZip, String ccNumber, String ccExpiration, String ccCVV, List<Shawarma> shawarmas) {
        this.id = id;
        this.placedAt = placedAt;
        this.deliveryName = deliveryName;
        this.deliveryStreet = deliveryStreet;
        this.deliveryCity = deliveryCity;
        this.deliveryState = deliveryState;
        this.deliveryZip = deliveryZip;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
        this.ccCVV = ccCVV;
        this.shawarmas = shawarmas;
    }

    public ShawarmaOrder() {
    }

    public void addShawarma(Shawarma shawarma) {
        shawarmas.add(shawarma);
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public void setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public String getDeliveryZip() {
        return deliveryZip;
    }

    public void setDeliveryZip(String deliveryZip) {
        this.deliveryZip = deliveryZip;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }

    public List<Shawarma> getShawarmas() {
        return shawarmas;
    }

    public void setShawarmas(List<Shawarma> shawarmas) {
        this.shawarmas = shawarmas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShawarmaOrder that = (ShawarmaOrder) o;
        return id.equals(that.id) && placedAt.equals(that.placedAt) && deliveryName.equals(that.deliveryName) && deliveryStreet.equals(that.deliveryStreet) && deliveryCity.equals(that.deliveryCity) && deliveryState.equals(that.deliveryState) && deliveryZip.equals(that.deliveryZip) && ccNumber.equals(that.ccNumber) && ccExpiration.equals(that.ccExpiration) && ccCVV.equals(that.ccCVV) && shawarmas.equals(that.shawarmas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placedAt, deliveryName, deliveryStreet, deliveryCity, deliveryState, deliveryZip, ccNumber, ccExpiration, ccCVV, shawarmas);
    }

    @Override
    public String toString() {
        return "ShawarmaOrder{" +
                "id=" + id +
                ", placedAt=" + placedAt +
                ", deliveryName='" + deliveryName + '\'' +
                ", deliveryStreet='" + deliveryStreet + '\'' +
                ", deliveryCity='" + deliveryCity + '\'' +
                ", deliveryState='" + deliveryState + '\'' +
                ", deliveryZip='" + deliveryZip + '\'' +
                ", ccNumber='" + ccNumber + '\'' +
                ", ccExpiration='" + ccExpiration + '\'' +
                ", ccCVV='" + ccCVV + '\'' +
                ", shawarmas=" + shawarmas +
                '}';
    }
}
