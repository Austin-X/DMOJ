import java.io.*;
import java.util.*;

public class TheInterlaceCypher {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t ++) {
			String option = br.readLine();
			String message = br.readLine();
			String decode = "";
			ArrayList<Integer> spaces = new ArrayList<Integer>();
			for (int i = 0; i < message.length(); i ++) {
				if (message.charAt(i) == ' ') spaces.add(i);
				else decode += message.charAt(i);
			}
			String[] parts = message.split(" ");
			
			int cn = 0;
			if (option.equals("encode")) {
				int idx = 0;
				boolean flag = false;
				while (!flag) {
					flag = true;
					
					for (int i = 0; i < parts.length; i ++) {
						if (idx >= parts[i].length()) continue;
						else { flag = false; System.out.print(parts[i].charAt(idx)); cn ++; }
						
						if (spaces.contains(cn)) { cn ++; System.out.print(" "); }
					}
					idx ++;
				}
			} else {
				int idx = 0;
				String[] ans = new String[parts.length];
				Arrays.fill(ans, "");
				
				for (int i = 0; i < decode.length(); i ++) {
					if (ans[idx].length() < parts[idx].length()) ans[idx] += decode.charAt(i);
					else i --;
					idx ++;
					if (idx == parts.length) idx = 0;
				}
				for (int i = 0; i < parts.length; i ++) {
					System.out.print(ans[i] + " ");
				}
			}
			System.out.println();
		}
	}
}
