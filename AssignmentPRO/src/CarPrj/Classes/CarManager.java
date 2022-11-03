/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPrj.Classes;

import CarPrj.Classes.Com.BrandList;
import CarPrj.Classes.Com.CarList;
import CarPrj.Classes.Com.Menu;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CarManager {

    public static void main(String[] args) {
        ArrayList ops = new ArrayList();
        BrandList brandList = new BrandList();
        brandList.loadFromFile(" ");
        CarList carList = new CarList(brandList);
        carList.loadFromFile(" ");
        int choice;
        Menu menu = new Menu();
        System.out.println("1. List all brands");
        System.out.println("2. Add a new brand");
        System.out.println("3. Search a brand based on its ID");
        System.out.println("4. Update a brand");
        System.out.println("5. Save brands to the file, named brands.txt");
        System.out.println("6. List all cars in ascending order of brand names");
        System.out.println("7. List cars based on a part of an input brand name");
        System.out.println("8. Add a car");
        System.out.println("9. Remove a car based on its ID");
        System.out.println("10. Update a car based on its ID");
        System.out.println("11. Save cars to file, named cars.txt");
        do {
            choice = menu.int_getChoice(ops);
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    Scanner sc = new Scanner(System.in);
                    String ID = sc.nextLine();
                    brandList.searchID(ID);
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.saveToFile("brands.txt");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    carList.printBasedBrandName();
                    break;
                case 8:
                    carList.addCar();
                    break;
                case 9:
                    carList.removeCar();
                    break;
                case 10:
                    carList.updateCar();
                    break;
                case 11:
                    carList.saveToFile("cars.txt");
                    break;
            }
        } while (choice > 0 && choice <= ops.size());
    }
}
