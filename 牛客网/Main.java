import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Set<Integer> s = new HashSet<Integer>();
		// for(Integer i = 0; i<10; i++) {
		// 	s.add(i);
		// 	s.remove(i - 1);
		// }
		// System.out.println(s.size());
		int i = 0;
		int s = 0;
		while(i <= 100) {
			int x = i % 10;
			int y = i / 10 % 10;
			int z = i / 100;
			if(i % 7 == 0 || x == 7 || y == 7 || z == 7) {
				s += i;
			}
			i++;
		}
		System.out.println(s);
	}
}