package com.example.supply_buddy;

public class Retail {

    private String Raw_material;
    private String From;
    private String To;
    private String Quantity;
    private String Location;

    public Retail() {
    }

    public String getRaw_material(){
        return Raw_material;
    }

    public void setRaw_material(String raw_material) {
        Raw_material = raw_material;
    }

    public String getFrom(){
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo(){
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getQuantity(){
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}