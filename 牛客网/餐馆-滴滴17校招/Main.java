import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class Pair implements Comparable<Pair>{
	int number;
	int money;

	public int compareTo(Pair other) {
		return this.money - other.money;
	}

	public String toString() {
		return "(" + number + "," + money + ")";
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n,m;
		n = scanner.nextInt();
		m = scanner.nextInt();
		int [][] tables = new int[2][n];
		Pair[] customers = new Pair[m];
		for(int i = 0; i < n; i++) {
			tables[0][i] = scanner.nextInt();
		}
		for(int i = 0; i < m; i++) {
			customers[i] = new Pair();
			customers[i].number = scanner.nextInt();
			customers[i].money = scanner.nextInt();			
		}

		Arrays.sort(tables[0]);
		Arrays.sort(customers,new Comparator<Pair>() {
			@Override
			public int compare(Pair a,Pair b) {
				return b.money - a.money;
			}
		});
		// String str1 = Arrays.toString(tables[0]);
		// String str2 = Arrays.toString(customers);
		// System.out.print(str1 + "\n" + str2);

		long sum = 0;
		for(int i = 0; i < m; i++) {
			int index = find(tables,customers[i].number);
			if(index != -1) {
				sum += customers[i].money;
				tables[1][index] = 1;
			}
		}
		System.out.print(sum);
	}

	private static int find(int[][] arr,int number) {
		int left = 0;
		int right = arr[0].length - 1;
		int mid = 0;
		while(left <= right) {
			mid = left + (right - left) / 2;
			if(arr[0][mid] == number) return mid;
			if(arr[0][mid] < number) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		// if(arr[0][mid] < number) {
			for(int i = mid; i < arr[0].length; i++) {
				if(arr[1][i] == 1) continue;
				if(arr[0][i] >= number) 
					return i;
			}
		// } else {
		// 	for(int i = mid; i >= 0; i--) {
		// 		if(arr[1][i] == 1) continue;
		// 		if(arr[0][i] >= number) 
		// 			return i;
		// 	}
		// }
		return -1;
	}
}
