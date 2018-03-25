import java.util.Scanner;
import java.util.Arrays;

public class NewSolution {
	public static void main(String[] args) {
		int n,s;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		s = scanner.nextInt();

		int []coin = new int[n];
	
		for(int i =0; i < n; i++)
			coin[i] = scanner.nextInt();

		int ans = 0;
		for(int x = 1; x < (1 << n); x++) {
			int min = 101;
			int sum = 0;
			int count = 0;
			for(int i = 0; i < n; i++) {
				if((x & (1 << i)) != 0) {
					min = Math.min(min,coin[i]);
					sum += coin[i];
					count++;
				}
			}
			if(sum >= s && sum - min < s)
				ans = Math.max(count,ans);
		}

		System.out.print(ans);
	}
}