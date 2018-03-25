public class Fibonacci {
	public static void main(String[] args) throws Exception{
		for(int i = 0; i < 100; i++)
			System.out.println(fibon(i));
	}

	public static long fibon(int n) throws Exception{
		if(n < 0) throw new Exception("参数错误");
		int[] result = {0,1};
		if(n < 2) return result[n];

		long first = 0;
		long second = 1;
		long ans = 0;

		for(int i = 2; i <= n; i++) {
			ans = first + second;
			first = second;
			second = ans;
		}

		return ans;
	}
}