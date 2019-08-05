import java.io.*;
import java.util.*;

public class SecretSanta {
	static int[] floors, weights;
	static int min = Integer.MAX_VALUE, n;
	static ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		floors = new int[n];
		weights = new int[n];
		
		int tot = 0;
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			floors[i] = f;
			weights[i] = w;
			tot += w;
		}
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = i;

		permute(arr);	
		solve(tot);
		System.out.println(min);
	}
	
	static ArrayList<Integer> temp = new ArrayList<Integer>();
	static void permute(int[] arr) {
		if (temp.size() == n) {
			permutations.add(new ArrayList<Integer>(temp)); return;
		} 
		
		for (int i = 0; i < n; i ++) {
			if (temp.contains(arr[i])) continue;
			temp.add(arr[i]);
			permute(arr);
			temp.remove(temp.size() - 1);
		}
	}
	
	static void solve(int tot) {
		for (int i = 0; i < permutations.size(); i ++) {
			int time = 0;
			int stress = tot;
			int curSpot = 101;
			for (int j = 0; j < permutations.get(i).size(); j ++) {
				time += stress * (Math.abs(curSpot - floors[permutations.get(i).get(j)]) + 1);
				stress -= weights[permutations.get(i).get(j)];
				curSpot = floors[permutations.get(i).get(j)];
			}
			min = Math.min(min, time);
		}
	}
}
