import java.io.*;
import java.util.*;

public class Systests {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int b = Integer.parseInt(br.readLine());
		
		int[] starts = new int[b];
		int[] ends = new int[b];
		int[] points = new int[b];
		
		for (int i = 0; i < b; i ++) {
			st = new StringTokenizer(br.readLine());
			starts[i] = Integer.parseInt(st.nextToken());
			ends[i] = Integer.parseInt(st.nextToken());
			points[i] = Integer.parseInt(st.nextToken());
		}
		
		int f = Integer.parseInt(br.readLine());
		int[] fails = new int[f];
		for (int i = 0; i < f; i ++) {
			fails[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(fails);
		
		int tot = 0;
		for (int i = 0; i < b; i ++) {	
			// Binary Search for lower bound
			int lower = Arrays.binarySearch(fails, starts[i]);
			
			// Binary search for upper bound
			int upper = Arrays.binarySearch(fails, ends[i]);
			
			if ((upper != lower) || lower >= 0 && upper >= 0) tot -= points[i];
			tot += points[i];
		}
		
		System.out.println(tot);
	}
}
