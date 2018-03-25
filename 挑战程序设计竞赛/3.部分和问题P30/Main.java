import java.util.Scanner;

public class Main { 
	private static int [] arr;
	private static int n; 
	private static int k;

	public static void main(String[] args) {
		arr = new int[]{1,2,4,7};
		k = 3;
		n = arr.length; 
		System.out.print(res(0,13));
		Scanner scanner = new Scanner(System.in);
		while(true) {
			k = scanner.nextInt();
		System.out.print(res(0,k));
		}

	}

	public static boolean res(int i,int k) {
		if(i == n) return (k == 0);
		if(res(i + 1,k - arr[i])) return true;
		if(res(i + 1,k)) return true;
		return false;
	}
}