package programmers.practice_kit.stack;

import java.util.*;

class Solution {
    public boolean solution(String s) {
        // 스택 문제는 ArrayList가 아니라 Stack을 사용
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
