package com.example.anamoslim.data.pojo.PrayerTiming;

public class Timing {
    private  String prayName;
    private  String prayTime;

    public Timing(String prayName, String prayTime) {
        this.prayName = prayName;
        this.prayTime = prayTime;
    }

    public String getPrayName() {
        return prayName;
    }

    public String getPrayTime() {
        return prayTime;
    }
}
