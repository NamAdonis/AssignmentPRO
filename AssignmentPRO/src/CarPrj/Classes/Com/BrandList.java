/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes.Com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BrandList extends ArrayList<Brand>{

    public boolean loadFromFile(String fileName) {
        try {
            File f = new File(fileName);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()) {
                Brand brand = new Brand();
                String[] properties = sc.nextLine().split(": ");
                brand.setPrice(Double.parseDouble(properties[1]));
                brand.setBrandID(properties[0].split(", ")[0]);
                brand.setBrandName(properties[0].split(", ")[1]);
                brand.setSoundBrand(properties[0].split(", ")[2]);
                this.add(brand);
            }
            sc.close();
            return true;
        } catch (FileNotFoundException | NumberFormatException e) {
            System.err.println("An error occurs: Details: " + e);
            System.exit(1);
        }
        return false;
    }
    
    public boolean saveToFile(String fileName) {
        try {
            File f = new File(fileName);
            if(!f.exists()) f.createNewFile();
            FileWriter fw = new FileWriter(f);
            for (Brand brand : this) {
                fw.write(brand + "\n");
            }
            fw.close();
            return true;
        } catch (IOException e){
            System.out.println("An error occurs: Details: " + e);
        }
        return false;
    }
    
    public Brand getUserChoice() {
        Menu mnu = new Menu();
        return (Brand)mnu.ref_getChoice(this);
    }
    
    public int searchID(String bID) {
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).getBrandID().equalsIgnoreCase(bID)) {
                return i;
            }
        }
        return - 1;
    }
    
    public void addBrand() {
        Scanner sc = new Scanner(System.in);
        Brand br = new Brand();
        String ids = "";
        for (Brand brand : this) {
            ids += brand.getBrandID() + " ";
        }
        System.out.print("Enter brand ID: ");
        String brandId = sc.nextLine();
        while(ids.contains(brandId)) {
            System.out.print("Brand Id has already been in list. Enter again: ");
            brandId = sc.nextLine();
        }
        br.setBrandID(brandId);
        System.out.print("Enter brand name: ");
        br.setBrandName(sc.nextLine());
        System.out.print("Enter sound brand: ");
        br.setSoundBrand(sc.nextLine());
        System.out.print("Enter brand price: ");
        br.setPrice(sc.nextDouble());
        this.add(br);
    }
    
    public void updateBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter brand id to update: ");
        String brandId = sc.nextLine();
        int pos = this.searchID(brandId);
        if (pos < 0) System.out.println("Not Found!");
        else {
            System.out.print("Enter brand name: ");
            this.get(pos).setBrandName(sc.nextLine());
            System.out.print("Enter sound brand: ");
            this.get(pos).setSoundBrand(sc.nextLine());
            this.get(pos).setPrice(this.get(pos).getPrice() * 2);
        }
    }
    
    public void listBrands() {
        this.forEach((o) -> {System.out.println(o);});
    }
}
