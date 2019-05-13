import java.io.*;

public class FindDates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean leapYear = false;
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.length() >= 10) {
				for (int j = 0; j < str.length() - 9; j++) {
					leapYear = false;
					if (Character.isDigit(str.charAt(j)) && Character.isDigit(str.charAt(j + 1))
							&& Character.isDigit(str.charAt(j + 2)) && Character.isDigit(str.charAt(j + 3))
							&& str.charAt(j + 4) == '-' && Character.isDigit(str.charAt(j + 5))
							&& Character.isDigit(str.charAt(j + 6)) && str.charAt(j + 7) == '-'
							&& Character.isDigit(str.charAt(j + 8)) && Character.isDigit(str.charAt(j + 9))) {
						if (!str.substring(j, j + 4).equals("0000")) {
							if ((Integer.parseInt(str.substring(j, j + 4)) % 400 == 0) || (Integer.parseInt(str.substring(j, j + 4)) % 4 == 0 && Integer.parseInt(str.substring(j, j + 4)) % 100 != 0)) leapYear = true;
							else leapYear = false;
							
							if (Integer.parseInt(str.substring(j + 5, j + 7)) <= 12 && Integer.parseInt(str.substring(j + 5, j + 7)) >= 1) {
								if ((str.substring(j + 5, j + 7).equals("01") || str.substring(j + 5, j + 7).equals("03") || str.substring(j + 5, j + 7).equals("05")
										|| str.substring(j + 5, j + 7).equals("07") || str.substring(j + 5, j + 7).equals("08") || str.substring(j + 5, j + 7).equals("10")
										|| str.substring(j + 5, j + 7).equals("12")) && str.substring(j + 8, j + 10).compareTo("31") <= 0 && str.substring(j + 8, j + 10).compareTo("01") >= 0) {
									System.out.println(str.substring(j, j + 10));
								}
								else if ((str.substring(j + 5, j + 7).equals("04") || str.substring(j + 5, j + 7).equals("06") || str.substring(j + 5, j + 7).equals("09")
										|| str.substring(j + 5, j + 7).equals("11")) && str.substring(j + 8, j + 10).compareTo("30") <= 0 && str.substring(j + 8, j + 10).compareTo("01") >= 0) {
									System.out.println(str.substring(j, j + 10));
								}
								else if (leapYear == false && (str.substring(j + 5, j + 7).equals("02")) && str.substring(j + 8, j + 10).compareTo("28") <= 0 && str.substring(j + 8, j + 10).compareTo("01") >= 0) {
									System.out.println(str.substring(j, j + 10));
								}
								else if (leapYear == true && (str.substring(j + 5, j + 7).equals("02")) && str.substring(j + 8, j + 10).compareTo("29") <= 0 && str.substring(j + 8, j + 10).compareTo("01") >= 0) {
									System.out.println(str.substring(j, j + 10));
								}
							}
						}
					}
				}
			}
		}
	}
}
