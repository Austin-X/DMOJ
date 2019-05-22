import java.io.*;
import java.util.*;

// Done on IPhone
public class LonerPhoner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String number = sc.nextLine();
            if (number.length() == 10 && (number.substring(0, 3).equals("416") || number.substring(0, 3).equals("647"))) System.out.println("(" + number.substring(0, 3) + ")-" + number.substring(3, 6) + "-" + number.substring(6));
            else System.out.println("not a phone number");
        }
    }
}
