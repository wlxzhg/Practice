import java.util.Arrays;

public class ShellSort {
	public static <T extends Comparable> void shellSort(T[] a) {
		int j;
		for(int gap = a.length / 2; gap >= 1; gap /= 2) {
			for(int i = gap; i < a.length; i++) {
				T tmp = a[i];
				for(j = i; j >= gap && a[j - gap].compareTo(tmp) > 0; j -= gap)
					a[j] = a[j - gap];
				a[j] = tmp;
			}
		}
	}

	public static void main(String [] args) {
		Integer [] arr = {4,-9,19,-10,88,90,3};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}