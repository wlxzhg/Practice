import java.util.Arrays;

public class MergeSort {
	private static <T extends Comparable> void merge(T[] a,T[] tmpArr,int leftPos,int rightPos,int rightEnd) {
		int leftEnd = rightPos - 1;
		int elementNums = rightEnd - leftPos + 1;
		int tmpPos = leftPos;
		while(leftPos <= leftEnd && rightPos <= rightEnd) {
			if(a[leftPos].compareTo(a[rightPos]) <= 0)
				tmpArr[tmpPos++] = a[leftPos++];
			else
				tmpArr[tmpPos++] = a[rightPos++];
		}

		while(leftPos <= leftEnd)
			tmpArr[tmpPos++] = a[leftPos++];

		while(rightPos <= rightEnd)
			tmpArr[tmpPos++] = a[rightPos++];

		for(int i = 0; i < elementNums;i++,rightEnd--)
			a[rightEnd] = tmpArr[rightEnd];
	}

	private static <T extends Comparable> void mergeSort(T[] a,T[] tmpArr,int left,int right) {
		if(left < right) {
			int center = (left + right) / 2;
			mergeSort(a,tmpArr,left,center);
			mergeSort(a,tmpArr,center+1,right);
			merge(a,tmpArr,left,center+1,right);
		}
	}


	//not recursion
	private static <T extends Comparable> void mergeSort(T[] a,T[] tmpArr) {
		int right,left,center;

		for(int length = 2; length <= (a.length * 2); length *= 2) {
			for(int i = 0; i < a.length; i += length) {
				left = i;
				right = left + length - 1;
				center = left + length / 2 - 1;
				if(right >= a.length) right = a.length - 1;
				if(center >= right) center = right;
				merge(a,tmpArr,left,center+1,right); 
			}
		}
	}


	//public api
	public static <T extends Comparable> void mergeSort(T [] a) {
		T[] tmpArr = (T[]) new Comparable[a.length];
		mergeSort(a,tmpArr,0,a.length -1);
		// mergeSort(a,tmpArr);
	}
}