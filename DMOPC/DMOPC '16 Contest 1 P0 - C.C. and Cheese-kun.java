import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       // Done on IPhone
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int w = Integer.parseInt(br.readLine());
       int c = Integer.parseInt(br.readLine());
       
       if (w == 3 && c >= 95) System.out.println("C.C. is absolutely satisfied with her pizza.");
       else if (w == 1 && c <= 50) System.out.println("C.C. is fairly satisfied with her pizza.");
       else System.out.println("C.C. is very satisfied with her pizza.");
    }
}
