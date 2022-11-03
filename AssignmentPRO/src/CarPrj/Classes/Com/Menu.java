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
 * @param <E> subclass of object class
 */
public class Menu <E extends Object>{
    
    public int int_getChoice(ArrayList<E> options) {
        Scanner sc = new Scanner(System.in);
        int response;
        int N = options.size();
        for (int i = 0; i < N; i++) {
            System.out.println((i+1) +". " + options.get(i));
        }
   
        System.out.print("Please choose an option from 1 to " + N + ": ");
        response  = sc.nextInt();
        return response;
    }
    
    public E ref_getChoice (ArrayList<E> options) {
        int response;
        int N = options.size();
        do {            
            response = int_getChoice(options);
        } 
        while (response < 0 || response > N);
        return options.get(response -1);
    }

}
