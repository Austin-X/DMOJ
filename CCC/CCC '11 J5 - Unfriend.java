import java.io.*;
import java.util.*;

public class Unfriend {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] sets = new int[7];
		Arrays.fill(sets, 1);
		
		for (int i = 1; i < n; i ++) {
			int x = Integer.parseInt(br.readLine());
			sets[x] *= sets[i] + 1;
		}
		
		System.out.println(sets[n]);
	}
}
