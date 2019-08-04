import java.io.*;
import java.util.*;

public class Vauvau {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		
		int max = Math.max(p, m);
		max = Math.max(max, g);
		
		int cur = 0;
		int time1 = 0, time2 = 0;
		
		int[] cn = new int[3];
		boolean firstDog = true, secondDog = true;
		while (cur <= max) {
			if (cur == p && firstDog) cn[0] ++;
			if (cur == m && firstDog) cn[1] ++;
			if (cur == g && firstDog) cn[2] ++;
			if (cur == p && secondDog) cn[0] ++;
			if (cur == m && secondDog) cn[1] ++;
			if (cur == g && secondDog) cn[2] ++;
			
 			if (firstDog && time1 == a) {
				firstDog = false; time1 = 0;
			} else if (!firstDog && time1 == b) {
				firstDog = true; time1 = 0;
			}
			if (secondDog && time2 == c) {
				secondDog = false; time2 = 0;
			} else if (!secondDog && time2 == d) {
				secondDog = true; time2 = 0;
			}
			
			time1 ++; time2 ++; cur ++;
		}
		
		for (int i = 0; i < 3; i ++) {
			if (cn[i] == 0) System.out.println("none");
			else if (cn[i] == 1) System.out.println("one");
			else System.out.println("both");
		} 
	} 
}
