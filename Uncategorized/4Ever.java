import java.io.*;
import java.util.*;

public class FourEver {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String word = String.valueOf(n);
		
		int ans = 0;
		int cn = 1;
		
		while (ans != 4) {
			ans = 0;
			cn = 1;
			int place = 1;
			
			boolean thousand = false, million = false;
			for (int i = word.length() - 1; i >= 0; i --) {
				if (cn == 1 && i > 0 && word.charAt(i - 1) == '1') {
					switch (word.substring(i - 1, i + 1)) {
						case "10": ans += 3; break;
						case "11": ans += 6; break;
						case "12": ans += 6; break;
						case "13": ans += 8; break;
						case "14": ans += 8; break;
						case "15": ans += 7; break;
						case "16": ans += 7; break;
						case "17": ans += 9; break;
						case "18": ans += 8; break;
						case "19": ans += 8; break;
					}
					i--;
					cn++;
					
					if (place >= 4 && place <= 6 && word.charAt(i) != '0') thousand = true;
					else if (place >= 7 && place <= 9 && word.charAt(i) != '0') million = true;
					if (place % 3 == 0 && word.charAt(i) != '0') ans += 7;
					
					place ++;
				} else if (cn == 2) {
					switch (Character.getNumericValue(word.charAt(i))) {
						case 2: ans += 6; break;
						case 3: ans += 6; break;
						case 4: ans += 5; break;
						case 5: ans += 5; break;
						case 6: ans += 5; break;
						case 7: ans += 7; break;
						case 8: ans += 6; break;
						case 9: ans += 6; break;
					}
				} else {
					switch (Character.getNumericValue(word.charAt(i))) {
						case 1: ans += 3; break;
						case 2: ans += 3; break;
						case 3: ans += 5; break;
						case 4: ans += 4; break;
						case 5: ans += 4; break;
						case 6: ans += 3; break;
						case 7: ans += 5; break;
						case 8: ans += 5; break;
						case 9: ans += 4; break;
					}
					
				}

				if (place >= 4 && place <= 6 && word.charAt(i) != '0') thousand = true;
				else if (place >= 7 && place <= 9 && word.charAt(i) != '0') million = true;
				if (place % 3 == 0 && word.charAt(i) != '0') ans += 7;
				
				cn ++;
				place ++;
				if (cn == 4) cn = 1;
			}
				
			if (thousand) ans += 8;
			if (million) ans += 7;
			if (word.length() == 10 && word.charAt(0) != '0') ans += 7;
			
			System.out.println(ans);
			word = String.valueOf(ans);
		}
	}
}
