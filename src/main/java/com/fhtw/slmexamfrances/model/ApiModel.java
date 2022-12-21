package com.fhtw.slmexamfrances.model;

import org.springframework.stereotype.Service;

@Service
public class ApiModel {
    private double price = 0;
    private double taxPercent = 0;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public double calculateTax(){
        return (this.price + this.price*this.taxPercent/100);
    }
}
