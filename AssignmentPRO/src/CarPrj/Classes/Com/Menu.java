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
public class Menu {
    
    public int int_getChoice(ArrayList<String> options) {
        Scanner sc = new Scanner(System.in);
        int response;
        int N = options.size();
        for (int i = 0; i < N; i++) {
            System.out.println((i+1) +". " + options.get(i));
        }
   
        System.out.println("Please choose an option from 1 to 11: ");
        response  = sc.nextInt();
        return response;
    }
    
    public String ref_getChoice (ArrayList<String> options) {
        int response;
        int N = options.size();
        do {            
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
            response = int_getChoice(options);
        } 
        while (response < 0 || response > N);
        return options.get(response -1);
    }

}
