import java.util.*;
import java.io.*;

public class HappyOrSad {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int happyCn = 0, sadCn = 0;
		String line = br.readLine();
		for (int i = 0; i < line.length() - 2; i ++) {
			if (line.substring(i, i + 3).equals(":-)")) happyCn ++;
			else if (line.substring(i, i + 3).equals(":-(")) sadCn ++;
		}
		if (happyCn > sadCn) System.out.println("happy");
		else if (sadCn > happyCn) System.out.println("sad");
		else if (sadCn == 0 && happyCn == 0) System.out.println("none");
		else System.out.println("unsure");
	}
}
