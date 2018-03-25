import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;
        int [] board = {n / 100,n / 20,n / 10,n / 5,n};
        for(int e = 0;e <= board[0];e++) {
            for(int d = 0;d<=board[1];d++) {
                for(int c = 0;c <= board[2]; c++) {
                    for(int b = 0; b <= board[3]; b++) {
                        for(int a = 0; a <= board[4]; a++) {
                            if(a + 5 * b + 10 * c + 20 * d + 100 * e == n) ans++;
                        }
                    }
                }
            }
        }
        
        System.out.print(ans);
    }
}