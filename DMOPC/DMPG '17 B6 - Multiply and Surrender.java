import java.io.*;
import java.util.*;

public class MultiplyAndSurrender {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		 double x, product = 0;
		 int n = Integer.parseInt(br.readLine());
		 
		 st = new StringTokenizer(br.readLine());
		 for (int i = 0; i < n; i++) {
		   x = Double.parseDouble(st.nextToken());
		   product += Math.pow((Math.log(2) / Math.log(x)), -1);
		 }
		 System.out.println((long) Math.floor(product) + 1);
	}
}
