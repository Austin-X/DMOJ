import java.io.*;
import java.util.*;

public class SecretSanta {
	static int[] floors, weights;
	static int n, totStress, min = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		floors = new int[n];
		weights = new int[n];
		
		totStress = 0;
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			floors[i] = f;
			weights[i] = w;
			totStress += w;
		}
		
		permute();
		solve();
		System.out.println(min);
		
	}
	
	static ArrayList<Integer> temp = new ArrayList<Integer>();
	static void permute() {
		if (temp.size() == n) {
			res.add(new ArrayList<Integer>(temp));
		}
		
		for (int i = 0; i < n; i ++) {
			if (!temp.contains(i)) {
				temp.add(i); 
				permute();
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	static void solve() {
		for (int i = 0; i < res.size(); i ++) {
			int curFloor = 101;
			int stress = totStress;
			int time = 0;
			for (int j = 0; j < res.get(i).size(); j ++) {
				time += stress * (Math.abs(curFloor - floors[res.get(i).get(j)]) + 1);
				stress -= weights[res.get(i).get(j)];
				curFloor = floors[res.get(i).get(j)];
			}
			min = Math.min(min, time);
		}
	}
}
