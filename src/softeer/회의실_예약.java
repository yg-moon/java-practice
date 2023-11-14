package softeer;

import java.io.*;
import java.util.*;

public class 회의실_예약 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = sc.nextLine();
        }
        Arrays.sort(names);

        HashMap<String, int[]> dic = new HashMap<>();
        for (String name : names) {
            int[] times = new int[18];
            Arrays.fill(times, 1);
            dic.put(name, times);
        }

        for (int i = 0; i < M; i++) {
            String[] input = sc.nextLine().split(" ");
            String r = input[0];
            int s = Integer.parseInt(input[1]);
            int t = Integer.parseInt(input[2]);
            for (int j = s; j < t; j++) {
                dic.get(r)[j] = 0;
            }
        }

        for (String name : names) {
            List<String> start = new ArrayList<>();
            List<String> end = new ArrayList<>();
            int idx = 9;

            // 사용 가능한 시간대 파악
            while (idx < 18) {
                int cnt = 1;
                if (dic.get(name)[idx] == 1) {
                    while (idx + cnt < 18 && dic.get(name)[idx + cnt] == 1) {
                        cnt++;
                    }
                    if (idx == 9) {
                        start.add("09");
                    } else {
                        start.add(String.valueOf(idx));
                    }
                    end.add(String.valueOf(idx + cnt));
                }
                idx += cnt;
            }

            // 요구사항대로 출력
            System.out.println("Room " + name + ":");
            if (start.isEmpty()) {
                System.out.println("Not available");
            } else {
                System.out.println(start.size() + " available:");
                for (int i = 0; i < start.size(); i++) {
                    System.out.println(start.get(i) + "-" + end.get(i));
                }
            }
            if (!name.equals(names[N - 1])) {
                System.out.println("-----");
            }
        }
    }
}
