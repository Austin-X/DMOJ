import java.util.*;
import java.io.*;
	
public class Distance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int min = 1, max = n;
		
		while (min <= max) {
			System.out.print(min + " ");
			min ++;
			
			if (min > max) break;
			
			System.out.print(max + " ");
			max --;
		}
	}
}
