package edu.selu.cgonzales.hammondddd.Data;

public class Business extends Entity {

    private String phoneNumber;
    private String category;
    private String website;

    public Business(String name, String location, String phoneNumber, String category,
                    String website){
        super(name, location);
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.website = website;
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
}
