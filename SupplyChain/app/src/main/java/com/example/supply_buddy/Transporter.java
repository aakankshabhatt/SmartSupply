package com.example.supply_buddy;

import android.content.Intent;

public class Transporter {

    private String Quantity;
    private String Boxes;
    private String Location;
    private String ConfirmPrize;

    public Transporter() {
    }

    public String getQuantity(){
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getBoxes(){
        return Boxes;
    }

    public void setBoxes(String boxes) {
        Boxes = boxes;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getConfirmPrize(){
        return ConfirmPrize;
    }

    public void setConfirmPrize(String confirmPrize) {
        ConfirmPrize = confirmPrize;
    }


}
