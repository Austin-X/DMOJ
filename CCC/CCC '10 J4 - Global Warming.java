import java.io.*;
import java.util.*;

public class GlobalWarming {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			if (n == 1) {
				System.out.println(0); continue;
			}
			
			int[] arr = new int[n];
			int[] diff = new int[n];
			
			for (int i = 0; i < n; i ++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (i > 0) diff[i] = arr[i] - arr[i - 1];
			}
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] patterns = new ArrayList[n + 1];
			for (int i = 0; i <= n; i ++) patterns[i] = new ArrayList<Integer>();

			for (int i = 2; i <= n; i ++) {
				for (int j = 1; j < i; j ++) {
					patterns[i].add(diff[j]);
				}
			}
			
			int min = 0;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 1; i <= n; i ++) {
				if (i != n) temp.add(diff[i]);
				boolean bool = true;
				
				int index = 1, tempIndx = 0;
				while (index < n) {
					if (temp.get(tempIndx) != diff[index]) {
						bool = false; break;
					}
					if (tempIndx == temp.size() - 1) tempIndx = 0;
					else tempIndx ++;
					index ++; 
				}
				if (bool) {
					min = i; break;
				}
			}
			System.out.println(min);
		}
	}
}
