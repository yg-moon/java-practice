package softeer;

import java.io.*;
import java.util.*;

public class 금고털이 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int W = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int info[][] = new int[N][2];
    int answer = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      info[i][0] = Integer.parseInt(st.nextToken());
      info[i][1] = Integer.parseInt(st.nextToken());
    }

    // 핵심
    Arrays.sort(info, (a, b) -> Integer.compare(b[1], a[1]));

    for (int i = 0; i < N; i++) {
      if (W <= 0) {
        break;
      }

      int amount = Math.min(W, info[i][0]);
      answer += amount * info[i][1];
      W -= amount;
    }

    System.out.println(answer);
    br.close();
  }
}
