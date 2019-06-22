import java.util.*;
import java.io.*;

public class BobAndCandies {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		int c = Integer.parseInt(arr[2]);
		int cn = 0;
		
		while (b > 0) {
			b -= a;
			if (b < 0) break;
			cn ++;
		}
		
		if (cn > c) cn = c;
		System.out.println(cn);
	}
}
