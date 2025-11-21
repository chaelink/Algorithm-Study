import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        List<Integer> answer = new ArrayList<>();
        int n = plays.length;
       
        // 1. 장르, 고유번호 리스트
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }
        
        // 2. 장르 별 총 재생 수 계산 (count, 장르명)
        Map<Integer, String> countToGenre = new HashMap<>();
        List<Integer> totalList = new ArrayList<>();
        
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String genre = entry.getKey();
            List<Integer> list = entry.getValue();
            
            int total = 0;
            for (int idx : list) {
                total += plays[idx];
            }
            
            // count를 key로 써도 무조건 유일함 (문제 조건)
            countToGenre.put(total, genre);
            totalList.add(total);
        }
        
        // 3. 장르 총 재생 수 내림차순 정렬
        totalList.sort(Collections.reverseOrder());
        
        // 4. 각 장르별로 가장 많이 재생된 노래 순으로 정렬 후 1~2곡 추가
        for (int total : totalList) {
            String genre = countToGenre.get(total); //장르 이름
            List<Integer> list = map.get(genre);    //장르 고유 번호 목록
            
            //목록 카운트 내림차순, 고유 번호 오름차순
            list.sort((a,b) -> {
                if(plays[a] != plays[b]) {
                    return plays[b] - plays[a];
                } else {
                    return a - b;
                }
            });
            
            
            // 장르 내 노래 정렬 (재생수 내림차순 → 고유번호 오름차순)
            // list.sort((a, b) -> {
            //     if (plays[b] != plays[a]) return plays[b] - plays[a];
            //     return a - b;
            // });
            
            
            // 1곡 또는 2곡 선택
            answer.add(list.get(0));
            if (list.size() > 1) {
                answer.add(list.get(1));
            }
        }
        
        // 결과 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
