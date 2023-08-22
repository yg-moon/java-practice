package programmers.kakao._2020_blind;

class Solution {
    public static int solution(String s) {
        String minStr = s;

        // 모든 단위길이에 대해 압축 시도
        for (int unit = 1; unit <= s.length(); unit++) {
            String curStr = "";
            int i = 0;
            // 현재 문자열이 끝날 때까지 진행
            while (i < s.length()) {
                String chunk = s.substring(i, Math.min(i + unit, s.length()));
                int cnt = 1;
                // 반복표현이 나오는 만큼 탐색
                while (i + unit * 2 <= s.length() && chunk.equals(s.substring(i + unit, i + unit * 2))) {
                    i += unit;
                    cnt++;
                }
                i += unit;
                // 현재 문자열에 추가
                if (cnt != 1) {
                    curStr += Integer.toString(cnt);
                }
                curStr += chunk;
            }

            if (curStr.length() < minStr.length()) {
                minStr = curStr;
            }
        }

        return minStr.length();
    }

    public static void main(String[] args) {
        int ans = solution("aabbaccc");
        System.out.println(ans);
    }

}
