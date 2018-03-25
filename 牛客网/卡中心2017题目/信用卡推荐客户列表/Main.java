// import java.util.Scanner;
// import java.util.HashMap;
// import java.util.Map.Entry;
import java.util.*;

	class Node {
		public Node left;
		public Node right;
		public Character value;

		public Node(Character value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int m = scanner.nextInt();
		int n = scanner.nextInt();

		HashMap<Character,Node> nodeMap = new HashMap<Character,Node>(2 * m);

		// for(int i = 0; i < m; i++) {
		while(scanner.hasNext()) {
			String line = scanner.nextLine();
			if(line == null || line.length() == 0) break;
			char f = line.charAt(0);
			char s = line.charAt(2);
			char t = line.charAt(4);

			Node root = nodeMap.get(f);
			if(root == null) root = new Node(f);

			Node left = new Node(s);
			Node right = null;
			if(t != '*') right = new Node(t);
			root.left = left;
			root.right = right;

			nodeMap.put(f,root);
		}

		ansMap = new HashMap<Character,Integer>(2 * m);

		childNum(nodeMap.get('A'));
		Set<Map.Entry<Character,Integer>> set = ansMap.entrySet();
		StringBuilder str = new StringBuilder("None");
		for(Map.Entry<Character,Integer> entry : set) {
			if(entry.getValue() > n) {
				str.append(entry.getKey());
				str.append(" ");
			}
		}
		System.out.print(str.toString());
	}

	private static HashMap<Character,Integer> ansMap;

	private static int childNum(Node root) {
		if(ansMap.get(root.value) != null)
			return ansMap.get(root.value);
		int ans = 0;
		if(root.left != null)
			ans += 1 + childNum(root.left);
		if(root.right != null)
			ans += 1 + childNum(root.right);
		ansMap.put(root.value,ans);
		return ans;
	}
}