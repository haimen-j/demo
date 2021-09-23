package com.zuson.demo.entity;

import java.util.HashMap;
import java.util.Map;

public class AddressInfo {

    private String status;

    private Map<String,Double> location = new HashMap<>();

    private String formatted_address;
    private String business;
    private Map addressComponent = new HashMap();

    private String level;//县市区级别

    private Integer confidence;//

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Double> getLocation() {
        return location;
    }

    public void setLocation(Map<String, Double> location) {
        this.location = location;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public Map getAddressComponent() {
        return addressComponent;
    }

    public void setAddressComponent(Map addressComponent) {
        this.addressComponent = addressComponent;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "status='" + status + '\'' +
                ", location=" + location +
                ", formatted_address='" + formatted_address + '\'' +
                ", business='" + business + '\'' +
                ", addressComponent=" + addressComponent +
                '}';
    }
}

