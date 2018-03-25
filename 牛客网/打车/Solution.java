import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public  int s;
	public  int n;
	public int[] coin;
	public int[] tmp;

	public Solution(){}

	public Solution(int s,int n) {
		this.s = s;
		this.n = n;
		this.coin = new int[n];
		this.tmp = new int[n];
	}

	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int n,s;
		n = scanner.nextInt();
		s = scanner.nextInt();

		Solution solution = new Solution(s,n);

		int [] coin = new int[n];
		for(int i = 0; i < n; i++)
			solution.coin[i] = scanner.nextInt();
		System.out.println(s + " " + n);
		System.out.println(Arrays.toString(solution.coin));

		System.out.println(solution.dfs(0,0,0));
		System.out.println(Arrays.toString(solution.tmp));
	}	


	//i 遍历到元素的下标
	//sum当前的和
	//numbers已经加了几个数了
	//返回值 加下去直到sum大于等于指定值，最多多少个元素
	private int dfs(int i,int sum,int numbers) {
		// if(tmp[i] != 0)
		// 	return tmp[i];

		if(sum >= s) return numbers;

		if(i == (n - 1))
			if(sum + coin[i] >= s)
				return numbers + 1;
			else //加到n了还达不到要求，说明这条路径错误
				return -1;



		int notPlus = dfs(i + 1, sum, numbers);
		int plus = dfs(i + 1, sum + coin[i], numbers + 1);
		// tmp[i] = Math.max(notPlus,plus);
		System.out.println(i + " : " + numbers + " " + sum+" " + notPlus + " " + plus);
		return Math.max(notPlus,plus);
	}
}