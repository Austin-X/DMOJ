import java.util.*;
import java.io.*;

public class Registration {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cn = 0;
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		
		arr = br.readLine().split(" ");
		
		for (int i = 0; i < arr.length; i ++) {
			cn += Integer.parseInt(arr[i]);
		}
		
		if (cn > 200) System.out.println("Over maximum capacity!");
		else System.out.println(200 - cn);
	}
}
