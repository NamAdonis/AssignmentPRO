/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CarList extends ArrayList<Car>{
    private BrandList brandList;
    
    public CarList(BrandList bList){
        this.brandList = bList;
    } 
    
    public boolean loadFromFile(String filename){
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()) {
                String[] line = sc.nextLine().split(", ");
                Car car = new Car();
                car.setCarID(line[0]);
                int pos = brandList.searchID(line[1]);
                car.setBrand(brandList.get(pos));
                car.setColor(line[2]);
                car.setFrameID(line[3]);
                car.setEngineID(line[4]);
                this.add(car);
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    public boolean saveToFile(String filename){
        try {
            File f = new File(filename);
            if(!f.exists()) f.createNewFile();
            FileWriter fw = new FileWriter(f);
            for (Car car : this) {
                fw.write(car + "\n");
            }
            fw.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurs: Details: " + e);
        }
        return true;
    }
    
    public int searchID(String carID){
        int N = this.size();
        for (int i = 0; i < N - 1; i++) {
            if (this.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchFrame(String fID){
        int N = this.size();
        for (int i = 0; i < N - 1; i++) {
            if (this.get(i).getFrameID().equals(fID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchEngine(String eID){
        int N = this.size();
        for (int i = 0; i < N - 1; i++) {
            if (this.get(i).getEngineID().equals(eID)) {
                return i;
            }
        }
        return -1;
    }
    
    public void addCar(){
        Scanner sc = new Scanner(System.in);
        Car car = new Car();
        System.out.print("Enter Car Id: ");
        String carID = sc.nextLine();
        while(this.searchID(carID) != -1) {
            System.out.println("Car Id has already been in list. Enter again: ");
            carID = sc.nextLine();
        }
        car.setCarID(carID);
        Menu menu = new Menu();
        Brand b = (Brand)menu.ref_getChoice(brandList);
        car.setBrand(b);
        System.out.print("Enter color of car: ");
        car.setColor(sc.nextLine());
        System.out.print("Enter frame Id of car: ");
        car.setFrameID(sc.nextLine());
        System.out.print("Enter engine Id of car: ");
        car.setEngineID(sc.nextLine());
        this.add(car);
    }
    
    public void printBasedBrandName(){
        String aPartOfBrandName = TestInput.checkBlankStr("Input a part of brand name: ");
        int N = this.size();
        int count = 0;
        
        for (int i = 0; i < N - 1; i++) {
            Car c = this.get(i);
            if (c.getBrand().getBrandName().contains(aPartOfBrandName.toUpperCase())) {
                System.out.println(c.screenString());
                count++;
            }
        }
        if(count == 0) System.out.println("No car is detected!");
    }
    
    public boolean removeCar(){
        String removedID = TestInput.checkBlankStr("Input remove car ID: ");
        int pos = searchID(removedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            remove(pos);
            System.out.println("Car ID has been remove!");
        }
        return true;
    }
    
    public boolean updateCar(){
        String updatedID = TestInput.checkBlankStr("Input car ID want to update: ");
        String color, frameID, engineID; 
        int pos = searchID(updatedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            Car car = this.get(pos);
            Scanner sc = new Scanner(System.in);
            Menu menu = new Menu();
            Brand b = (Brand)menu.ref_getChoice(brandList);
            car.setBrand(b);
            System.out.print("Enter color of car: ");
            car.setColor(sc.nextLine());
            System.out.print("Enter frame Id of car: ");
            car.setFrameID(sc.nextLine());
            System.out.print("Enter engine Id of car: ");
            car.setFrameID(sc.nextLine());
        }
        return true;
    }
    
    public void listCars() {
        Collections.sort(this);
        int N = this.size();
        for (int i = 0; i < N; i++) {
            Car c = this.get(i);
            System.out.println(c.screenString());
        }
    }
}
