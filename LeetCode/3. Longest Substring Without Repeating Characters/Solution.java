public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
		System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
		System.out.println(solution.lengthOfLongestSubstring("aaaaaaaa"));
		System.out.println(solution.lengthOfLongestSubstring("abcdbabcde"));
		System.out.println(solution.lengthOfLongestSubstring(""));
		System.out.println(solution.lengthOfLongestSubstring(null));
		System.out.println(solution.lengthOfLongestSubstring("aaaaabbbbb"));



	}

	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int start = 0,ans = 1;
        for(int end = 1; end < arr.length; end++) {
        	for(int j = start; j < end; j++) {
        		if(arr[j] == arr[end]) {
        			start = j + 1;
        		}
        	}
        	ans = (end - start + 1 > ans)?(end - start + 1):ans;
        }
        return ans;
    }
}