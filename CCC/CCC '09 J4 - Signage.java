import java.io.*;
import java.util.ArrayList;

public class Signage {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sign = { "WELCOME", "TO", "CCC", "GOOD", "LUCK", "TODAY" };

		int w = Integer.parseInt(br.readLine());

		ArrayList<String> output = new ArrayList<String>();
		int cur = 0;
		int length = sign[0].length();
		for (int i = 1; i <= 6; i++) {
			if (i == 6) {
				String temp = "";
				for (int j = cur; j < i; j++) {
					if (j != i - 1)
						temp += sign[j] + ".";
					else
						temp += sign[j];
				}
				output.add(temp);
			} else if (w >= length + sign[i].length() + 1) {
				length += sign[i].length() + 1;
			} else {
				String temp = "";
				for (int j = cur; j < i; j++) {
					if (j != i - 1)
						temp += sign[j] + ".";
					else
						temp += sign[j];
				}
				output.add(temp);
				cur = i;
				length = sign[i].length();
			}
		}

		for (int i = 0; i < output.size(); i++) {
			int howManySpaces = w - output.get(i).length();

			StringBuilder tem = new StringBuilder(output.get(i));

			int sp = 0, cn = 0, extra = 1;
			if (moreThanOneWord(output.get(i))) {
				for (int k = 0; k < output.get(i).length(); k++) {
					if (k == output.get(i).length() - 1) {
						sp = 0; k = 0; extra ++;
					}
					if (cn == howManySpaces) break;
					if (output.get(i).charAt(k) == '.') {
						tem.insert(k + sp, ".");
						cn ++;
						sp += extra;
					}
				}
			} else {
				for (int k = 0; k < w; k ++) {
					if (k >= output.get(i).length()) tem.append(".");
				}
			}
			output.set(i, tem.toString());
		}

		for (String x : output)
			System.out.println(x);
	}

	public static boolean moreThanOneWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == '.') return true;
		}
		return false;
	}
}
