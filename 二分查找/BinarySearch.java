import java.util.Scanner;

public class BinarySearch {
	public static  <T extends Comparable> int search(T[] arr,T target) {
		int low = 0,high = arr.length,mid;
		int tmp;
		while(low <= high) {
			mid = (low + high) / 2;
			System.out.println("high == " + high + "   low == " + low +"   mid == " + mid);
			tmp = target.compareTo(arr[mid]);
			if(tmp > 0)
				low = mid + 1;
			else if(tmp < 0)
				high = mid - 1;
			else
				return mid; 
		} 
		return -1;
	}

	public static void main(String [] args) {
		Integer [] arr = {1,2,3,4,9,10,90,100};
		System.out.println(search(arr,14));
		System.out.println(search(arr,100));
		Scanner in = new Scanner(System.in);
		int a = 0;
		while (a != -1) {
			a = in.nextInt();
			System.out.println(search(arr,a));
		}
	}
}