/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarManagement;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Brand {
    protected String brandID;
    protected String brandName;
    protected String soundBrand;
    protected double price;

    Scanner sc = new Scanner(System.in);
    
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
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        System.out.print("Enter sound brand: ");
            soundBrand = sc.next();
            while(soundBrand.isEmpty()) {
                System.out.print("Soound brand cannot be blank. Enter again: ");
                soundBrand = sc.next();
            }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        System.out.print("Enter price: ");
            price = sc.nextDouble();
            while(price <= 0) {
                System.out.print("Price must greater than 0. Enter again: ");
                price = sc.nextDouble();
            } 
    }

    //Sửa toString() theo yêu cầu của assignment
    @Override
    public String toString() {
        return "Brand{" + "brandID=" + brandID + ", brandName=" + brandName + ", soundBrand=" + soundBrand + ", price=" + price + '}';
    }
    
    
}
