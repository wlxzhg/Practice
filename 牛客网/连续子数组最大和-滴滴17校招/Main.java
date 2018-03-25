import java.util.Scanner;

/**
* AC 2018-03-20
*/
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		int [] arr = new int[n];

		for (int i = 0; i < n; i++ ) {
			arr[i] = scanner.nextInt();	
		}

		int sum = 0,biggestSum = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
			if(sum > biggestSum) biggestSum = sum;
			if(sum < 0) sum = 0;
		}

		System.out.print(biggestSum);
	}
}