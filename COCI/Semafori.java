import java.io.*;
import java.util.*;

public class Semafori {
	 public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);

		    int n = sc.nextInt();
		    int l = sc.nextInt();
		    int time = 0;
		    int d, r, g;

		    for (int i = 0; i < n; i++){
		      d = sc.nextInt();
		      r = sc.nextInt();
		      g = sc.nextInt();
		      int count = 0;
		      boolean green = false;
		      
		      // Calculating how much time Luka needs to wait
		      for (int j = 0; j < d + time; j++){
		        count++;
		        if (count == r && !green) {
		          green = true;
		          count = 0;
		        }
		        else if (count == g && green){
		          green = false;
		          count = 0;
		        }
		      }
		      
		      // Adding wait time
		      if (!green) time += r - count;
		    }
		   
		    // Adding wait time to total distance time.
		    time += l;
		    
		    System.out.println(time);
		  }
}
