package programmers.practice_kit.brute_force;

import java.util.*;

class Solution {
    static Set<Integer> primeSet = new HashSet<>();
    static boolean[] visited;
    static char[] charArr;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        charArr = numbers.toCharArray();
        makePermutations("");
        return primeSet.size();
    }

    // 자바에는 itertools가 없으므로 직접 만들어야 함
    private void makePermutations(String curStr) {
        if (curStr != "") {
            int num = Integer.parseInt(curStr);
            if (isPrime(num)) {
                primeSet.add(num);
            }

        }
        if (curStr.length() == charArr.length)
            return;

        for (int i = 0; i < charArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makePermutations(curStr + charArr[i]);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
