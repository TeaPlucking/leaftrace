package com.datapirates.leaftrace;

public class teaweightRecord {
    private String pluckersId;
    private String amount;
    private String area;
    private String date;


    public teaweightRecord() {
    }
    // constructors for the firebase to store the data
    public teaweightRecord(String pluckersId, String amount, String area, String date) {
        this.pluckersId = pluckersId;
        this.amount = amount;
        this.area = area;
        this.date = date;
    }

    public String getPluckersId() {
        return pluckersId;
    }

    public String getAmount() {
        return amount;
    }

    public String getArea() {
        return area;
    }

    public String getDate() {
        return date;
    }
}
