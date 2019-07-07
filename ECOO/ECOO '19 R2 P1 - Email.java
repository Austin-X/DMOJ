import java.io.*;
import java.util.*;

public class Email {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t ++) {
			int n = Integer.parseInt(br.readLine());
			HashSet<String> emails = new HashSet<String>();
			
			for (int i = 0; i < n; i ++) {
				String email = br.readLine().toLowerCase();
				
				String newEmail = "";
				boolean at = false, plus = false;
				for (int j = 0; j < email.length(); j ++) {
					if (email.charAt(j) == '@') at = true;
					else if (!plus && email.charAt(j) == '+' && !at) {
						plus = true;
					} else if (!plus && email.charAt(j) != '.') {
						newEmail += email.charAt(j);
					} else if (at) newEmail += email.charAt(j);
				}

				emails.add(newEmail);
			}
			
			System.out.println(emails.size());
		}
	}
}
