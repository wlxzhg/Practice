import java.util.Arrays;

public class MergeSortTest {
	public static void main(String[] args) {
		Integer[][] arr = {
			{5,2,0,-19,199,900,333,-1000,3452,9,32,8,9},
			{1},
			{},
			{1,2,3,4,5,6,7,8,9},
			{100,89,45,9,1,-100,-3},
			{-1,-1,-1,-1,-1,-1,-1}
		};

		for(int index = 0; index < arr.length; index++) {
			MergeSort.mergeSort(arr[index]);
			System.out.println(Arrays.toString(arr[index]));
		}


		// Integer [] a = {5,2,0,-19,199,900,333,-1000,3452,9,32,8,9};
		// int [] b = {1};
		// int [] c = {};
		// int [] d = {1,2,3,4,5,6,7,8,9};
		// int [] e = {100,89,45,9,1,-100,-3};
		// int [] f = {-1,-1,-1,-1,-1,-1,-1};

		// MergeSort.mergeSort(a);
		// MergeSort.mergeSort(b);
		// MergeSort.mergeSort(c);
		// MergeSort.mergeSort(d);
		// MergeSort.mergeSort(e);
		// MergeSort.mergeSort(f);

		// System.out.println(Arrays.toString(a));

		// System.out.println(Arrays.toString(a));
	}
}