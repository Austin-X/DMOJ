import java.io.*;
import java.util.*;

public class AddUpApples {
	static int n;
	static HashSet<ArrayList<Integer>> check = new HashSet<ArrayList<Integer>>();
	static ArrayList<Integer> temp = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		if (n != 1) {
			recurse(1, 0);
			for (ArrayList<Integer> x : check) {
				System.out.print(n + "=");
				for (int j = 0; j < x.size(); j ++) {
					if (j == x.size() - 1) System.out.println(x.get(j));
					else System.out.print(x.get(j) + "+");
				}
			}
			System.out.println("total=" + check.size());
		}
		else System.out.println("total=0");
	}
	
	static void recurse(int idx, int sum) {
		if (sum > n) return;
		else if (sum == n) {	
			if (temp.get(0) != n) check.add(new ArrayList<Integer>(temp));
			return;
		}
		
		for (int i = idx; i <= n/2; i ++) {
			temp.add(i);
			recurse(i, sum + i);
			
			temp.remove(temp.size() - 1);
			temp.add(n - i);
			recurse(n - i, sum + (n - i));
			
			temp.remove(temp.size() - 1);
		}
	}
}
