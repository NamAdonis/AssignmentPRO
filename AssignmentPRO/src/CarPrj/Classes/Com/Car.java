/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

/**
 *
 * @author Admin
 */
public class Car implements Comparable<Car>{
   protected String carID;
   protected Brand brand;
   protected String color;
   protected String frameID;
   protected String engineID;

    public Car() {
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }
    
    public String screenString(){
        return brand + "\n" + " " + carID + ", " + color + ", " + frameID + ", " + engineID;
    }

    @Override
    public String toString() {
        return carID + ", " + brand + ", " + color + ", " + frameID + ", " + engineID ;
    }

    @Override
    public int compareTo(Car c) {
        int d = this.brand.brandName.compareTo(c.brand.brandName);
        if (d != 0) {
            return d;
        }
        return this.carID.compareTo(c.carID);
    }
   
   
}
