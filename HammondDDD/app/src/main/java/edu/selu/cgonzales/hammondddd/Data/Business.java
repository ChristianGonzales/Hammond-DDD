package edu.selu.cgonzales.hammondddd.Data;

import com.google.android.gms.maps.model.LatLng;

public class Business {
    private String name;
    private String address;
    private String phoneNumber;
    private String category;
    private String website;
    private LatLng latLon;

    public Business(String name, String address,
                    String phoneNumber, String category,
                    String website, LatLng latLon) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.website = website;
        this.latLon = latLon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public LatLng getLatLon() {
        return latLon;
    }

    public void setLatLon(LatLng latLon) {
        this.latLon = latLon;
    }
}
