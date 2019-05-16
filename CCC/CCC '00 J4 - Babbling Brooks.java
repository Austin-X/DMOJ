import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BabblingBrooks {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Double> streams = new ArrayList<Double>();
		
		int choice = 0;
		double flow = 0;
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i ++) {
			flow = Double.parseDouble(br.readLine());
			streams.add(flow);
		}
		
		while (true) {
			choice = Integer.parseInt(br.readLine());
			if (choice == 77) break;
			else if (choice == 99) {
				choice = Integer.parseInt(br.readLine());
				flow = Double.parseDouble(br.readLine());
				streams.add(choice - 1, streams.get(choice - 1) / 100 * flow);
				streams.set(choice, streams.get(choice) - streams.get(choice - 1));
			}
			else if (choice == 88){
				choice = Integer.parseInt(br.readLine());
				streams.set(choice, streams.get(choice - 1) + streams.get(choice));
				streams.remove(choice - 1);
			}
		}
		
		for (double x : streams) System.out.print((int)Math.round(x) + " ");
	}
}
