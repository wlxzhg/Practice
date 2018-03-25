public class number3 {
	public boolean Find(int target,int[][] array) {
		if(array == null || array.length == 0 || array[0].length == 0) return false;

		int i = 0,j = array[0].length - 1;
        while(i < array.length && 0<=j) {
            if(array[i][j] == target) {
        		// System.out.println("(" + i + "," + j + ")");
            	return true;
            }
            if(array[i][j] > target) j--;
            else i++;
        }
        return false;
	}
	public static void main(String[] args) {
		int[][] a = {
			{1,2,8,9},
			{2,4,8,12},
			{4,7,10,13},
			{6,8,11,15}};
		int[][] b = {
			{1,1},
			{1,1}
		};

		number3 solution = new number3();
		System.out.print(solution.Find(2,b));
		System.out.print(solution.Find(1,b));
		System.out.print(solution.Find(-1,b));

	}
}