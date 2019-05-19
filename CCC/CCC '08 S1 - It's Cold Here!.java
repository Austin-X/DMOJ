import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ItsColdHere {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int coldestTemp = 201;
		String coldestCity = "";
		
		while (true) {
			String [] data = br.readLine().split(" ");
			
			if (Integer.valueOf(data[1]) < coldestTemp) {
				coldestTemp = Integer.valueOf(data[1]);
				coldestCity = data[0];
			}
			
			if (data[0].equals("Waterloo")) {
				break;
			}
		}
		System.out.println(coldestCity);
	}
}
