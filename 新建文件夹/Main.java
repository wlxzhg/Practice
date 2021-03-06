import java.util.Arrays;

public class Main {
	public static final int CUTOFF = 10;
	// {-1,10,3,9,10,90,100,-11,8,1000,-333,0,22,4,99,19,10,45},
	public static <T extends Comparable> void quickSort(T[] a,int left,int right) {
		if(left + CUTOFF <= right) {
			T pivot = median3(a,left,right);
			// System.out.println(pivot);
			// System.out.println(Arrays.toString(a));
			int i = left,j = right - 1;
			for(;;) {
				while(a[++i].compareTo(pivot) < 0){}
				while(a[--j].compareTo(pivot) > 0){}
				if(i < j)
					swapReference(a,i,j);
				else
					break;
			}
			// System.out.println(Arrays.toString(a));

			swapReference(a,i,right - 1);

			quickSort(a,left,i - 1);
			quickSort(a,i + 1,right);
		} else {
			insertionSort(a,left,right);
		}
	}

	private static <T extends Comparable> T median3(T[] a,int left,int right) {
		int center = (right + left) / 2;
		if(a[center].compareTo(a[left]) < 0)
			swapReference(a,left,center);
		if(a[right].compareTo(a[left]) < 0)
			swapReference(a,left,right);
		if(a[right].compareTo(a[center]) < 0)
			swapReference(a,center,right);

		swapReference(a,center,right - 1);
		return a[right - 1];
	}

	private static <T extends Comparable> void swapReference(T[] a,int left,int right) {
		T tmp = a[left];
		a[left] = a[right];
		a[right] = tmp;
	}

	private static <T extends Comparable> void insertionSort(T[] a,int left,int right) {
		int j;
		for(int i = left + 1; i <= right; i++) {
			T tmp = a[i];
			for(j = i; j > left && a[j-1].compareTo(tmp) > 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	public static void main(String[] args) {
		Integer [][] arrs = {
			{-1,10,3,9,10,90,100,-11,8,1000,-333,0,22,4,99,19,10,45},
			{-1,10,3,9,10,90,100,-11,8,893,-333,11,92,4,99,19,10,45},
			{-1,910,3,9,-10,0,130,-11,8,130,-333,22,233,4,-99,19,10,45},
			{-1,10,30,9,10,90,100,-13,8,1000,-333,33,-22,4,99,19,10,45},
			{-1,10,300,-900,10,90,104,-11,8,1000,-333,0,2,4,99,19,10,450}
		};

		for(int i = 0; i < arrs.length; i++) {
			quickSort(arrs[i],0,arrs[i].length-1);
			System.out.println(Arrays.toString(arrs[i]));
		}
	}

}