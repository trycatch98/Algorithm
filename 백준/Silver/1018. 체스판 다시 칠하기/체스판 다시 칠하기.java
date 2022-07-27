import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int whiteCount = 0, blackCount = 0, minCount = -1;

        char arr[][] = new char[N][M];

        for (int n = 0; n < N; n++) { //체스판 입력
            String str = sc.next();
            arr[n] = str.toCharArray();
        }
        char whiteChess[][] = createChess('W');
        char blackChess[][] = createChess('B');


        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {

                for (int row = i; row < i + 8; row++) {
                    for (int column = j; column < j + 8; column++) {
                        if (arr[row][column] != whiteChess[row - i][column - j])
                            whiteCount++;
                        if (arr[row][column] != blackChess[row - i][column - j])
                            blackCount++;
                    }
                }
                int tempCount = Math.min(whiteCount, blackCount);
                if (minCount == -1 || tempCount < minCount) {
                    minCount = tempCount;
                }
                whiteCount = 0;
                blackCount = 0;
            }
        }

        System.out.println(minCount);

    }

    static private char[][] createChess(char base) {
        char chess[][] = new char[8][8];
        char nextChess = base;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chess[i][j] = nextChess;
                nextChess = getNextChess(nextChess);
            }
            nextChess = chess[i][7];
        }
        return chess;
    }

    static private char getNextChess(char chess) {
        if (chess == 'W') return 'B';
        else return 'W';
    }
}