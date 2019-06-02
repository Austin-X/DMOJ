import java.io.*;
import java.util.*;

public class CarHoppers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 5; t++) {
			int guards = 0;
			String[] arr = br.readLine().split(" ");
			int n = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			int[] cars = new int[1002];

			for (int i = 1; i <= n; i++) {
				cars[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 1; i <= n;) {
				int loc = i, next = i;
				for (int j = i; j <= i + m && j <= n; j++) {
					if (cars[j] >= cars[loc])
						loc = j;
				}
				guards++;
				for (next = loc; next <= loc + m && next <= n; next++) {
					if (cars[next] > cars[loc])
						break;
				}
				i = next;
			}
			System.out.println(guards);
		}
	}
}
