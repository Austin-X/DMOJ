import java.io.*;

public class SpeedFinesAreNotFine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sLimit = Integer.parseInt(br.readLine());
		int speed = Integer.parseInt(br.readLine());
		
		if (speed <= sLimit) System.out.println("Congratulations, you are within the speed limit!");
		else if (speed <= sLimit + 20) System.out.println("You are speeding and your fine is $100.");
		else if (speed <= sLimit + 30) System.out.println("You are speeding and your fine is $270.");
		else System.out.println("You are speeding and your fine is $500.");
	}
}
