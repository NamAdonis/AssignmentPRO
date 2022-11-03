/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CarList extends ArrayList<Car>{
    BrandList brandList;
    public CarList(BrandList bList){
        
    }

   //toString()
    
    
    public boolean loadFromFile(String filename){
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            if (!f.exists()) return false;
            //Làm tiếp tại đây
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }  
        return true;
    }
    
    public boolean saveToFile(String filename){
        try {
            
        } catch (Exception e) {
        }
        return true;
    }
    
    public int searchID(String carID){
        int N = this.size();
        for (int i = 0; i < N - 1; i++) {
            if (this.get(i).carID == carID) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchFrame(String fID){
        int N = this.size();
        for (int i = 0; i < N - 1; i++) {
            if (this.get(i).frameID == fID) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchEngine(String eID){
        int N = this.size();
        for (int i = 0; i < N - 1; i++) {
            if (this.get(i).engineID == eID) {
                return i;
            }
        }
        return -1;
    }
    
    public void addCar(){
        String carID, color, frameID, engineID;
        boolean duplicated;
        //Brand b = (Brand)Menu.ref_getChoice(brandList);
    }
    
    public void printBasedBrandName(){
        String aPartOfBrandName = TestInput.checkBlankStr("Input a part of brand name: ");
        int N = this.size();
        int count = 0;
        
        for (int i = 0; i < N - 1; i++) {
            Car c = this.get(i);
            if (c.brand.brandName.contains(aPartOfBrandName.toUpperCase())) {
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
        //    Brand b =  //Chỉnh khi có menu
        
        }
        return true;
    }
}
