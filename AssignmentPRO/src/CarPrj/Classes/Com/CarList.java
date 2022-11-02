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
                return 1;
            }
        }
        return -1;
    }
    
    public int searchFrame(String fID){
        int N = this.size();
        for (int i = 0; i < N - 1; i++) {
            if (this.get(i).frameID == fID) {
                return 1;
            }
        }
        return -1;
    }
    
    public int searchEngine(String eID){
        int N = this.size();
        for (int i = 0; i < N - 1; i++) {
            if (this.get(i).engineID == eID) {
                return 1;
            }
        }
        return -1;
    }
    
    public void addCar(){
        String carID, color, frameID, engineID;
        boolean duplicated;
        
    }
    
    public void printBasedBrandName(){
        
    }
}
