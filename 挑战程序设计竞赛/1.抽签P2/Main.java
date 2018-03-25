import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,3,5,9,2,1,9,10,1,1,1,1,1,1,1,1,1,2,2,2,2,2,5,3,2,3,10,33,222,4,10,9,100,-9,345,32,4,5,3,2,3,4,19,23,25,87
			,23,4,100,9,9};
		int target = 18;
		System.out.print(solution(arr,target));		
	}

	//O(N^4)
	// public static boolean solution(int[] arr,int target) {
	// 	boolean ans = false;
	// 	for(int i = 0; i < arr.length; i++) {
	// 		for(int j = 0; j < arr.length; j++) {
	// 			for(int k = 0; k < arr.length; k++) {
	// 				for(int l = 0; l < arr.length; l++) {
	// 					if(arr[i] + arr[j] + arr[k] + arr[l] == target) {
	// 						ans = true;
	// 						break;
	// 					}
	// 				}
	// 			}
	// 		}
	// 	}

	// 	return ans;
	// }


	//O(N^3LogN)
	// public static boolean solution(int[] arr,int target) {
	// 	int tmp;
	// 	Arrays.sort(arr);
	// 	for(int i = 0; i < arr.length; i++) {
	// 		for(int j = 0; j < arr.length; j++) {
	// 			for(int k = 0; k < arr.length; k++) {
	// 				tmp = target - arr[i] - arr[j] - arr[k];
	// 				if(binarySearch(arr,tmp)) {
	// 					return true;
	// 				}
	// 			}
	// 		}
	// 	}
	// 	return false;
	// }

	//O(N^2LogN)
	public static boolean solution(int[] arr,int target) {
		int[] tmpArr = new int[arr.length * arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				tmpArr[i * arr.length + j] = arr[i] + arr[j];
			}
		}

		Arrays.sort(tmpArr);

		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(binarySearch(tmpArr,target - arr[i] - arr[j])) {
					return true;
				}
			}
		}

		return false;
	} 

	private static boolean binarySearch(int[] arr,int target) {
		int l = 0, r = arr.length;

		while(r - l >= 1) {
			int i = (l + r) / 2;
			if(arr[i] == target) return true;
			else if(arr[i] > target) l = i + 1;
			else r = i;
		}
		return false;
	}
}