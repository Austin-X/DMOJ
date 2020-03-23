import java.io.*;
import java.util.*;

public class AMedianProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> medians = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i ++) {
			arr.clear();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(arr);
			medians.add(arr.get(arr.size() / 2));
		}
		
		Collections.sort(medians);
		System.out.println(medians.get(medians.size() / 2));
	}
}
