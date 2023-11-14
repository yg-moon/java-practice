package softeer;

import java.io.*;
import java.util.*;

public class 팔단_변속기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stringNums = sc.nextLine().split(" ");
        int[] intNums = Arrays.stream(stringNums)
                .mapToInt(Integer::parseInt)
                .toArray();

        if (Arrays.equals(intNums, Arrays.stream(intNums).sorted().toArray())) {
            System.out.println("ascending");
        } else if (Arrays.equals(intNums, Arrays.stream(intNums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray())) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
