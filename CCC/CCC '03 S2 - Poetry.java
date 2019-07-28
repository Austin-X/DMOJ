import java.io.*;
import java.util.*;

public class Poetry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < n; t ++) {
			String line1 = br.readLine();
			String line2 = br.readLine();
			String line3 = br.readLine();
			String line4 = br.readLine();
			
			String rythme1 = findRythme(line1);
			String rythme2 = findRythme(line2);
			String rythme3 = findRythme(line3);
			String rythme4 = findRythme(line4);
			
			if (rythme1.equalsIgnoreCase(rythme2) && rythme2.equalsIgnoreCase(rythme3) && rythme3.equalsIgnoreCase(rythme4)) System.out.println("perfect");
			else if (rythme1.equalsIgnoreCase(rythme2) && rythme3.equalsIgnoreCase(rythme4)) System.out.println("even");
			else if (rythme1.equalsIgnoreCase(rythme3) && rythme2.equalsIgnoreCase(rythme4)) System.out.println("cross");
			else if (rythme1.equalsIgnoreCase(rythme4) && rythme2.equalsIgnoreCase(rythme3)) System.out.println("shell");
			else System.out.println("free");
		}
	}
	
	static String findRythme(String line) {
		int idx = -1;

		String[] parts = line.split(" ");
		String last = parts[parts.length - 1];
		
		for (int i = 0; i < last.length(); i ++) {
			if (last.charAt(i) == 'a' || last.charAt(i) == 'e' || last.charAt(i) == 'i' || last.charAt(i) == 'o' || last.charAt(i) == 'u') idx = i;
			else if (last.charAt(i) == 'A' || last.charAt(i) == 'E' || last.charAt(i) == 'I' || last.charAt(i) == 'O' || last.charAt(i) == 'U') idx = i;
		}
		
		if (idx != -1) {
			String rythme = "";
			for (int i = idx; i < last.length(); i ++) {
				if (last.charAt(i) == ' ') break;
				else rythme += last.charAt(i);
			}
			return rythme;
		}
		else return last;
	}
}
