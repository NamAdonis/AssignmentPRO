/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;


import java.util.*;

/**
 *
 * @author Admin
 */
public class Brand {
    private String brandID;
    private String brandName;
    private String soundBrand;
    private double price;

    private Scanner sc = new Scanner(System.in);
    
    public Brand() {
    }

    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        while(brandName.isEmpty()) {
            System.out.print("Name cannot be blank. Enter again: ");
            brandName = sc.next();
        }
        this.brandName = brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        while(soundBrand.isEmpty()) {
            System.out.print("Soound brand cannot be blank. Enter again: ");
            soundBrand = sc.next();
        }
        this.soundBrand = soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        while(price <= 0) {
            System.out.print("Price must greater than 0. Enter again: ");
            price = sc.nextDouble();
        } 
        this.price = price;
    }
    
    @Override
    public String toString() {
        return brandID + ", " + brandName + ", " + soundBrand + ": " + price;
    }
}
