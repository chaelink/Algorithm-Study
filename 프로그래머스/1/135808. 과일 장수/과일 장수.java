import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        //k점이 최상품 점수
        //m개 , 최저점 p, p*m이 가격
        //최대 이익 구하기
        // 1 ~ 3점, 4개 단위
        
        int n = score.length;
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(score[i]);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        int idx=-1;
        while((n-idx)>m) {
            idx += m;
            //System.out.println(idx + "," + list.get(idx));
            answer += list.get(idx)*m;
        }
        
        return answer;
    }
}