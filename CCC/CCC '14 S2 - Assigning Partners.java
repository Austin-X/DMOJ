import java.io.*;
import java.util.*;

public class AssigningPartners {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashMap<String, String> partners = new HashMap<String, String>();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		String[] line1 = new String[n];
		for (int i = 0; i < n; i ++) {
			line1[i] = st.nextToken();
		}
		
		st = new StringTokenizer(br.readLine());

		String[] line2 = new String[n];
		boolean good = false;
		for (int i = 0; i < n; i ++) {
			line2[i] = st.nextToken();
			partners.put(line1[i], line2[i]);
		}
		
		for (int i = 0; i < n; i ++) {
			if (partners.get(line1[i]).contains(line2[i]) && partners.get(line2[i]).contains(line1[i]) && !line1[i].equals(line2[i])) {
				good = true;
			} else {
				good = false; break;
			}
		}
		
		if (good) {
			if (partners.size() == n) good = true;
			else good = false;
		}
		
		System.out.println(good ? "good" : "bad");
	}
}
