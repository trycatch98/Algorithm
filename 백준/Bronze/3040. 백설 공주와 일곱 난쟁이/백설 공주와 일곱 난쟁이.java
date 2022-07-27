
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int number = Integer.parseInt(br.readLine());
            list.add(number);
            sum += number;
        }

        loop:
        for (int i = 0; i < 9; i++) {
            int temp;
            for (int j = i + 1; j < 9; j++) {
                int num1 = list.get(i);
                int num2 = list.get(j);
                temp = num1 + num2;
                if (sum - temp == 100) {
                    list.remove(Integer.valueOf(num1));
                    list.remove(Integer.valueOf(num2));
                    break loop;
                }
            }
        }

        for (int num : list) {
            bf.write(num + "\n");
        }

        bf.flush();

        br.close();
        bf.close();
    }
}