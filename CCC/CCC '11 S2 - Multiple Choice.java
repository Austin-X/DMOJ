import java.io.*;

public class MultipleChoice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cn = 0;
		char[] student = new char[n];
		
		for (int i = 0; i < n; i ++) student[i] = br.readLine().charAt(0);
		for (int i = 0; i < n; i ++) {
			char ans = br.readLine().charAt(0);
			if (ans == student[i]) cn ++;
		}
		System.out.println(cn);
	} 
}
