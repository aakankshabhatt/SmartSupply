package com.example.supply_buddy;

public class Godown {

    private String Date;
    private String Time;
    private String Quantity;

    public Godown() {
    }

    public String getDate(){
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
    public String getTime(){
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getQuantity(){
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}

