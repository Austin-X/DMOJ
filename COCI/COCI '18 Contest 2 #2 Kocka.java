import java.io.*;
import java.util.*;

public class Kocka {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] left = new int[n], right = new int[n], up = new int[n], down = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) left[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) right[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) up[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) down[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i ++) {
			if (left[i] == -1) {
				if (right[i] != -1) { System.out.println("NE"); System.exit(0); }
			} else {
				if (right[i] >= n - left[i]) { System.out.println("NE"); System.exit(0); }
				if (up[left[i]] > i || down[left[i]] >= n - i) { System.out.println("NE"); System.exit(0); }
			}
			
			if (right[i] == -1) {
				if (left[i] != -1) { System.out.println("NE"); System.exit(0); }
			} else {
				if (left[i] >= n - right[i]) { System.out.println("NE"); System.exit(0); }
				if (up[n - right[i] - 1] > i || down[n - right[i] - 1] >= n - i) { System.out.println("NE"); System.exit(0); }
			}
			
			if (up[i] == -1) {
				if (down[i] != -1) { System.out.println("NE"); System.exit(0); }
			} else {
				if (down[i] >= n - up[i]) { System.out.println("NE"); System.exit(0); }
				if (left[up[i]] > i || right[up[i]] > n - i - 1) { System.out.println("NE"); System.exit(0); }
			}
			
			if (down[i] == -1) {
				if (up[i] != -1) { System.out.println("NE"); System.exit(0); }
			} else {
				if (up[i] >= n - down[i]) { System.out.println("NE"); System.exit(0); }
				if (left[n - down[i] - 1] > i || right[n - down[i] - 1] > n - i - 1) { System.out.println("NE"); System.exit(0); }
			}
		}
		
		System.out.println("DA");
	}
}
