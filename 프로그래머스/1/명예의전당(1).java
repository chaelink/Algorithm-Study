import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int n = score.length;
        int[] answer = new int[n];
        //점수 내림 차순
        List<Integer> list = new ArrayList<>();
        
        
        for(int i=0; i<n; i++) {
            list.add(score[i]);
            Collections.sort(list, Collections.reverseOrder());
            if(list.size() < k) {
                answer[i] = list.get(list.size()-1);
            } else {
                answer[i] = list.get(k-1);
            }
        }
        
        //매일 한명 노래
        //매일 명예의 전당의 최하위 점수 발표
        return answer;
    }
}
