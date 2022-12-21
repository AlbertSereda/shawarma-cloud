package com.spring.shawarma.shawarmacloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShawarmaOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Shawarma> shawarmas = new ArrayList<>();

    public ShawarmaOrder(String deliveryName, String deliveryStreet, String deliveryCity, String deliveryState, String deliveryZip, String ccNumber, String ccExpiration, String ccCVV, List<Shawarma> shawarmas) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShawarmaOrder that = (ShawarmaOrder) o;
        return Objects.equals(deliveryName, that.deliveryName) && Objects.equals(deliveryStreet, that.deliveryStreet) && Objects.equals(deliveryCity, that.deliveryCity) && Objects.equals(deliveryState, that.deliveryState) && Objects.equals(deliveryZip, that.deliveryZip) && Objects.equals(ccNumber, that.ccNumber) && Objects.equals(ccExpiration, that.ccExpiration) && Objects.equals(ccCVV, that.ccCVV) && Objects.equals(shawarmas, that.shawarmas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryName, deliveryStreet, deliveryCity, deliveryState, deliveryZip, ccNumber, ccExpiration, ccCVV, shawarmas);
    }

    @Override
    public String toString() {
        return "ShawarmaOrder{" +
                "deliveryName='" + deliveryName + '\'' +
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
