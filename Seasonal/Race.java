import java.io.*;
import java.util.*;

public class Race {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] first = new int[3];
		for (int i = 0; i < 3; i ++) first[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] second = new int[3];
		for (int i = 0; i < 3; i ++) second[i] = Integer.parseInt(st.nextToken());
		
		int max = 0, sum = 0;
		for (int i = 0; i < 3; i ++) {
			max = Math.max(max, Math.abs(second[i] - first[i]));
			sum += Math.abs(second[i] - first[i]);
		}
		System.out.println(max);
		int ans2 = (int)Math.sqrt(Math.pow(Math.abs(first[0] - second[0]), 2) + Math.pow(Math.abs(first[1] - second[1]), 2) + Math.pow(Math.abs(first[2] - second[2]), 2));
		System.out.println(ans2);
		System.out.println(sum);
		
	}
}
