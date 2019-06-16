import java.io.*;

public class From1987To2013 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean bool = false;
		int year = Integer.parseInt(br.readLine());
		
		if (year >= 10) {
			while (bool == false) {
				year ++;
				String temp = Integer.toString(year);
				outerloop : for (int i = 0; i < temp.length(); i++) {
					for (int j = i + 1; j < temp.length(); j ++) {
						if (temp.charAt(i) == temp.charAt(j)) {
							bool = false; break outerloop;
						}
						else bool = true;
					}
				}
			}
			System.out.println(year);
		} else System.out.println(year + 1);
	}
}
