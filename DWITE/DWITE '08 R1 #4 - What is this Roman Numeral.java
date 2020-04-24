import java.io.*;
import java.util.*;

public class WhatIsThisRomanNumeral {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000);
		
		for (int t = 0; t < 5; t ++) {
			char[] ch = br.readLine().toCharArray();
			int ans = 0;
			
			int min = 100000;
			for (int i = 0; i < ch.length; i ++) {
				if (map.get(ch[i]) < min) {
					ans += map.get(ch[i]);
					min = map.get(ch[i]);
				}
				else if (map.get(ch[i]) > min) ans += map.get(ch[i]) - (2 * min);
				else ans += map.get(ch[i]);
			}
			System.out.println(ans);
		}
	}
}
