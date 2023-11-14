package softeer;

import java.io.*;
import java.util.*;

public class 전광판 {
    static HashMap<Character, String> dic = new HashMap<>();

    public static void main(String[] args) {
        dic.put('0', "1110111");
        dic.put('1', "0010010");
        dic.put('2', "1011101");
        dic.put('3', "1011011");
        dic.put('4', "0111010");
        dic.put('5', "1101011");
        dic.put('6', "1101111");
        dic.put('7', "1110010");
        dic.put('8', "1111111");
        dic.put('9', "1111011");
        dic.put(' ', "0000000");

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < T; i++) {
            String[] input = sc.nextLine().split(" ");
            String A = input[0];
            String B = input[1];
            System.out.println(solve(A, B));
        }
    }

    static int solve(String a, String b) {
        a = " ".repeat(5 - a.length()) + a;
        b = " ".repeat(5 - b.length()) + b;
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (dic.get(a.charAt(i)).charAt(j) != dic.get(b.charAt(i)).charAt(j)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}