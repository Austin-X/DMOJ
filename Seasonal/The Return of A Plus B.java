import java.util.Scanner;

public class TheReturnOfAPlusB {
	private static int parseInt(String s) {
	    switch (s) {
        case "1": case "one": case "un": case "一":
            return 1;
	    case "2": case "two": case "deux": case "二":
            return 2;
        case "3": case "three": case "trois": case "三":
            return 3;
        case "4": case "four": case "quatre": case "四":
            return 4;
        case "5": case "five": case "cinq": case "五":
            return 5;
        case "6": case "six": case "六":
            return 6;
        case "7": case "seven": case "sept": case "七":
            return 7;
        case "8": case "eight": case "huit": case "八":
            return 8;
        case "9": case "nine": case "neuf": case "九":
            return 9;
        case "10": case "ten": case "dix": case "十":
            return 10;
        default:
            return 5;
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.nextLine();
		for (int i = 0; i < n; i ++) {
			String a = sc.next();
			String b = sc.next();
			System.out.println(parseInt(a) + parseInt(b));
		}
		sc.close();
	}
}
