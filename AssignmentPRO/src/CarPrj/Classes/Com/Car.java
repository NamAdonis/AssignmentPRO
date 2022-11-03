/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Car implements Comparable<Car>{
   private String carID;
   private Brand brand;
   private String color;
   private String frameID;
   private String engineID;

   private Scanner sc = new Scanner(System.in);
   
    public Car() {
        brand = new Brand();
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
        while(color.isEmpty()) {
            System.out.print("Color cannot be empty. Enter again: ");
            color = sc.nextLine();
        }
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        while(frameID.isEmpty() || !frameID.matches("F\\d{5}")) {
            System.out.print("Frame ID cannot be empty and must be in form F#####. Enter again: ");
            frameID = sc.next();
        }
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        while(engineID.isEmpty() || !engineID.matches("E\\d{5}")) {
            System.out.print("Engine ID cannot be empty and must be in form E#####. Enter again: ");
            engineID = sc.next();
        }
        this.engineID = engineID;
    }
    
    public String screenString(){
        return brand + "\n" + " " + carID + ", " + color + ", " + frameID + ", " + engineID;
    }

    @Override
    public String toString() {
        return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID ;
    }

    @Override
    public int compareTo(Car c) {
        int d = this.brand.getBrandName().compareTo(c.brand.getBrandName());
        if (d != 0) {
            return d;
        }
        return this.carID.compareTo(c.carID);
    }
   
   
}
