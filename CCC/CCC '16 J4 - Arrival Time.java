import java.io.*;

public class CCC16J4ArrivalTime {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double distance = 120;
		String[] time = br.readLine().split(":");
		int hours = Integer.valueOf(time[0]);
		int minutes = Integer.valueOf(time[1]);
		int totalMinutes = hours * 60 + minutes;
		int elapsedTime = 0;
		
		while (distance != 0) {
			if (minutes == 60) {
				minutes = 0;
				hours ++;
			}
			if (hours >= 24) hours -= 24;
			minutes ++;
			elapsedTime ++;
			
			if ((hours >= 7 && hours < 10) || (hours == 10 && minutes == 0)) {
				distance -= 0.5;
			}
			else if((hours >= 15 && hours < 19) || (hours == 19 && minutes == 0)) {
				distance -= 0.5;
			}
			else distance --;
		}
		
		totalMinutes += elapsedTime;
		int finalMinutes = totalMinutes % 60;
		int finalHours = totalMinutes / 60;
		if (finalHours >= 24) finalHours = finalHours - 24;
		
		if (finalMinutes < 10 && finalHours < 10) System.out.println("0" + finalHours + ":" + "0" + finalMinutes);
		else if (finalMinutes < 10) System.out.println(finalHours + ":" + "0" + finalMinutes);
		else if (finalHours < 10) System.out.println("0" + finalHours + ":" + finalMinutes);
		else System.out.println(hours + ":" + finalMinutes);
	}
}
