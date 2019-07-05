import java.io.*;
import java.util.*;

public class Perket {
	public static ArrayList<ArrayList<Integer>> subsets(int[] s) {
		if (s == null) return null;
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < s.length; i ++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			
			// Get sets that are already in result;
			for (ArrayList<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}
			
			// Add s[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				a.add(s[i]);
			}
			
			// Add s[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(s[i]);
			temp.add(single);
			
			result.addAll(temp);
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] sourness = new int[n];
		int[] bitterness = new int[n];
		
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			sourness[i] = Integer.parseInt(st.nextToken());
			bitterness[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<ArrayList<Integer>> sour = subsets(sourness);
		ArrayList<ArrayList<Integer>> bitter = subsets(bitterness);
		
		int sourCn, bitterCn;
		for (int i = 0; i < sour.size(); i ++) {
			sourCn = 1; bitterCn = 0;
			for (int j = 0; j < sour.get(i).size(); j ++) {
				sourCn *= sour.get(i).get(j);
				bitterCn += bitter.get(i).get(j);
			}
			if (Math.abs(sourCn - bitterCn) < minDiff) minDiff = Math.abs(sourCn - bitterCn);
		}
		
		System.out.println(minDiff);
	}
}
