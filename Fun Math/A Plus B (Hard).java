import java.io.*;
import java.util.*;

public class APlusBHard {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			String max = "", min = "";
			
			int aLen = a.length(), bLen = b.length();
			int aCn = 0, bCn = 0;
			
			if (a.charAt(0) == '-') { aLen --; aCn ++; }
			if (b.charAt(0) == '-') { bLen --; bCn ++; }

			boolean neg = false;
			
			if (aLen > bLen) {
				max = a; min = b;
			} else if (aLen < bLen) {
				max = b; min = a;	
			} else {
				boolean flag = true;
				for (int j = 0; j < aLen; j ++) {
					if (Character.getNumericValue(a.charAt(j + aCn)) > Character.getNumericValue(b.charAt(j + bCn))) { flag = false; max = a; min = b; break; }
					else if (Character.getNumericValue(a.charAt(j + aCn)) < Character.getNumericValue(b.charAt(j + bCn))) { flag = false; max = b; min = a; break; }
				}
				
				if (flag) { 
					max = a; min = b; 
				}
			}
			
			int maxLen = Math.max(aLen, bLen);
			if (max.charAt(0) == '-') neg = true;
			if (max.charAt(0) == '-') max = new StringBuilder(max).deleteCharAt(0).toString();
			if (min.charAt(0) == '-') min = new StringBuilder(min).deleteCharAt(0).toString();
			
			int diff = max.length() - min.length();
			
			if (max.equals(min) && (a.charAt(0) == '-' && b.charAt(0) != '-' || a.charAt(0) != '-' && b.charAt(0) == '-')) { System.out.println("0"); continue; }
			else if (neg) System.out.print("-");
			
			char[] ans = new char[maxLen];
			if (a.charAt(0) != '-' && b.charAt(0) != '-' || a.charAt(0) == '-' && b.charAt(0) == '-') {	
				int carry = 0;
	
				for (int j = min.length() - 1; j >= 0; j --) {
					int x = Character.getNumericValue(min.charAt(j)) + Character.getNumericValue(max.charAt(j + diff));
					if (carry == 1) { x ++; carry = 0; }
					if (x >= 10) { x -= 10; carry = 1; }
					ans[j + diff] = (char)(x + '0');
				}
				
				for (int j = diff - 1; j >= 0; j --) {
					int x = Character.getNumericValue(max.charAt(j));
					if (carry == 1) { x ++; carry = 0; }
					if (x >= 10) { x -= 10; carry = 1; }
					ans[j] = (char)(x + '0');
				}
				
				if (carry == 1) System.out.print("1");
				for (int j = 0; j < maxLen; j ++) System.out.print(ans[j]);
				System.out.println();
			} else {	
				int carry = 0;
				for (int j = min.length() - 1; j >= 0; j --) {
					int x = Character.getNumericValue(max.charAt(j + diff)) - Character.getNumericValue(min.charAt(j));
					if (carry == 1) { x --; carry = 0; }
					if (x < 0) { x += 10; carry = 1; }
					ans[j + diff] = (char)(x + '0');
				}
				
				for (int j = diff - 1; j >= 0; j --) {
					int x = Character.getNumericValue(max.charAt(j));
					if (carry == 1) { x --; carry = 0; }
					if (x < 0) { x += 10; carry = 1; }
					ans[j] = (char)(x + '0');
				}

				boolean pass = false;
				for (int j = 0; j < maxLen; j ++) {
					if (!pass && ans[j] != '0') { System.out.print(ans[j]); pass = true; }
					else if (pass) System.out.print(ans[j]);
				}
				System.out.println();
			}
		}
	}
}
