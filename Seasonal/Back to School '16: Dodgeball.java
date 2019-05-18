import java.io.*;

public class BacktoSchool16Dodgeball {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] names = br.readLine().split(" ");
		int cn = names.length, extra = 0;
		
		for (int i = 0; i < names.length - 1; i ++) {
			if (names[i].substring(0, 1).equalsIgnoreCase(names[i + 1].substring(0, 1))) {
				for (int j = i + 1; j < names.length; j ++) {
					if (names[j - 1].substring(0, 1).equalsIgnoreCase(names[j].substring(0, 1))) {
						extra ++;
					}
					else {
						break;
					}
				}
				cn += extra;
				extra = 0;
			}
		}
		
		System.out.println(cn % 1000000007);
	}
}
