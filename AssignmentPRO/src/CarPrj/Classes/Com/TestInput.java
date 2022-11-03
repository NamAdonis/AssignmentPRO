package CarPrj.Classes.Com;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TestInput{
    private static Scanner sc = new Scanner(System.in);
    public static String normaLize(String s){
        StringTokenizer stk = new StringTokenizer(s, " ");
        String result = stk.nextToken();
        while (stk.hasMoreElements()) result += " " + stk.nextToken();
        return result;
    }
    
    public static String checkBlankStr(String mess){
        String result;
        do {            
            System.out.println(mess);
            result = normaLize(sc.nextLine());
        } while (mess.length() == 0);
        return result;
    }
}
