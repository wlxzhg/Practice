import java.util.Arrays;

public class InsertSort {
	public static <T extends Comparable> void insertSort(T[] a) {
		int j;
		for(int i = 1; i < a.length; i++) {
			T tmp = a[i];
			for(j = i; j > 0 && a[j-1].compareTo(tmp) > 0; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
 		}
	}

	public static void main(String [] args) {
		Integer [] arr = {4,-9,19,-10,88,90,3};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}