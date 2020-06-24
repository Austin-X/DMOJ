import java.io.*;
import java.util.*;

public class Autocomplete {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t ++) {
			int n = Integer.parseInt(br.readLine());
				
			int ans = 0;
			ArrayList<String> arr = new ArrayList<String>();
			
			for (int i = 0; i < n; i ++) {
				String x = br.readLine();

				int idx = -Collections.binarySearch(arr, x) - 1;
				arr.add(idx, x);
				
				if (arr.size() == 1) ans ++;
				else if (idx == 0) {
					int cn = x.length();
					for (int j = 0; j < x.length(); j ++) {
						if (j == arr.get(1).length()) { cn = j + 1; break; }
						else if (arr.get(1).charAt(j) != x.charAt(j)) {
							cn = j + 1; break;
						}
					}
					ans += cn;
				} else if (idx == arr.size() - 1) {
					int cn = x.length();
					for (int j = 0; j < x.length(); j ++) {
						if (j == arr.get(arr.size() - 2).length()) { cn = j + 1; break; }
						else if (arr.get(arr.size() - 2).charAt(j) != x.charAt(j)) {
							cn = j + 1; break;
						}
					}
					ans += cn;
				} else {
					int cn1 = -1, cn2 = -1;
					for (int j = 0; j < x.length(); j ++) {
						if (cn1 == -1) {
							if (j == arr.get(idx - 1).length()) cn1 = j + 1;
							else if (arr.get(idx - 1).charAt(j) != x.charAt(j)) cn1 = j + 1;
						}
						
						if (cn2 == -1) {
							if (j == arr.get(idx + 1).length()) cn2 = j + 1;
							else if (arr.get(idx + 1).charAt(j) != x.charAt(j)) cn2 = j + 1;
						}
					}
					cn1 = cn1 == -1 ? x.length() : cn1; cn2 = cn2 == -1 ? x.length() : cn2;
					ans += Math.max(cn1, cn2);
				}
			}
			
			System.out.println("Case #" + t + ": "  + ans);
		}
	}
}
