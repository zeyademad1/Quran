package com.example.anamoslim.data.pojo;

public class Zekr {

    private  String category , count , description , reference , zekr ;

    public Zekr(String category, String count, String description, String reference, String zekr) {
        this.category = category;
        this.count = count;
        this.description = description;
        this.reference = reference;
        this.zekr = zekr;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getZekr() {
        return zekr;
    }

    public void setZekr(String zekr) {
        this.zekr = zekr;
    }
}

