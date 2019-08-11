import java.io.*;
import java.util.*;

public class Veci {
	static int min = Integer.MAX_VALUE, num;
	static String x;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		x = br.readLine();
		num = Integer.parseInt(x);
		permute(x);
		solve();
		System.out.println(min != Integer.MAX_VALUE ? min : 0);
	}
	
	static ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> temp = new ArrayList<Integer>();
	static void permute(String x) {
		if (temp.size() == x.length()) {
			permutations.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = 0; i < x.length(); i ++) {
			if (!temp.contains(i)) {
				temp.add(i);
				permute(x);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	static void solve() {
		for (int i = 0; i < permutations.size(); i ++) {
			String check = "";
			for (int j = 0; j < permutations.get(i).size(); j ++) {
				check += x.charAt(permutations.get(i).get(j));
			}
			if (Integer.parseInt(check) > num) min = Math.min(min, Integer.parseInt(check));
		}
	}
}
