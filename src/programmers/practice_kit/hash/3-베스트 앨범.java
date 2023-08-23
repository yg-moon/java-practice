package programmers.practice_kit.hash;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlaysMap = new HashMap<>(); // {장르: 총 재생횟수}
        Map<String, List<List<Integer>>> genreInfoMap = new HashMap<>(); // {장르: [[고유번호1, 재생횟수1], ...]}

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genrePlaysMap.put(genre, genrePlaysMap.getOrDefault(genre, 0) + play);

            // getOrDefault를 못쓰면 이렇게 처리
            if (!genreInfoMap.containsKey(genre)) {
                genreInfoMap.put(genre, new ArrayList<>());
            }
            List<Integer> info = new ArrayList<>();
            info.add(i);
            info.add(play);
            genreInfoMap.get(genre).add(info);
        }

        // 리스트로 변환하고, 총 재생횟수 기준으로 정렬
        // List에 Map을 넣을때는 EntrySet으로 변환
        List<Map.Entry<String, Integer>> listGPM = new ArrayList<>(genrePlaysMap.entrySet());
        listGPM.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // 장르별 곡 목록을 재생횟수 기준으로 정렬
        for (List<List<Integer>> infoList : genreInfoMap.values()) {
            infoList.sort((a, b) -> Integer.compare(b.get(1), a.get(1)));
        }

        // 장르별 최대 2개의 곡까지만 수록
        List<Integer> answerList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : listGPM) {
            String genre = entry.getKey();
            int count = Math.min(genreInfoMap.get(genre).size(), 2);
            for (int i = 0; i < count; i++) {
                answerList.add(genreInfoMap.get(genre).get(i).get(0));
            }
        }

        // list -> array 변환: 스트림 사용 (직접 추가하는 것보다 훨씬 간결함)
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
