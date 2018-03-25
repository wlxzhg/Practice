import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int [] arr = {20,4,5,10};
		System.out.print(solution(arr));
	}

	public static int solution(int[] arr) {
		Arrays.sort(arr);
		int ans = 0;
		for(int i = arr.length - 1; i - 2 >= 0; i--) {
			if(arr[i - 2] + arr[i - 1] > arr[i]) {
				ans = arr[i] + arr[i - 1] + arr[i - 2];
				break;
			}
		}
		return ans;
	}
}