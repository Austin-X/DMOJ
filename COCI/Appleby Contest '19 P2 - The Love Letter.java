import java.io.*;

public class TheLoveLetter {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), l = Integer.parseInt(br.readLine());
		String s = br.readLine();
		for (int i = 0; i < n; i ++) {
			if (s.charAt(i) == 32) System.out.print(" ");
			else {
				int ascii = (int)s.charAt(i) + l;
				while (ascii > 122) ascii -= 26;
				System.out.print((char)ascii);
			}
		}
	}
}
