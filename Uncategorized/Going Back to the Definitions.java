import java.io.*;
import java.util.*;

public class GoingBackToTheDefinitions {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> nums = new ArrayList<String>();
		for (int i = 0; i < n; i ++) {
			String x =  br.readLine();
			int idx = nums.size();
			for (int j = 0; j < nums.size(); j ++) {
				String y = nums.get(j);
				if (x.length() > y.length()) {
					String temp = x.substring(0, y.length());
					if (temp.compareTo(y) > 0) { idx = j; break; }
					else if (temp.compareTo(y) == 0) {
						String a = x + y;
						String b = y + x;
						if (a.compareTo(b) >= 0) { idx = j; break; }
					}
				} else if (y.length() > x.length()) {
					String temp = y.substring(0, x.length());
					if (x.compareTo(temp) > 0) { idx = j; break; }
					else if (x.compareTo(temp) == 0) { 
						String a = x + y;
						String b = y + x;
						if (a.compareTo(b) >= 0) { idx = j; break; }
					}
				} else {
					if (x.compareTo(y) >= 0) { idx = j; break; }
				}
			}
			
			nums.add(idx, x);
		}

		for (String x : nums) System.out.print(x);
	}
}
