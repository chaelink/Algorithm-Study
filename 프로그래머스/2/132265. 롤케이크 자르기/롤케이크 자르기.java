import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        //해시맵 2개로 왼, 오
        //해시맵(토핑, 횟수)
        //슬라이딩 윈도우처럼 한쪽에서 빼고 한쪽에서 추가
        HashMap<Integer, Integer> cut1 = new HashMap<>();
        HashMap<Integer, Integer> cut2 = new HashMap<>();
        
        int n = topping.length;
        if(n==1) return 0;
        
        //맵 하나에 전부 카운트
        for(int i=0; i<n; i++) {
            cut1.put(topping[i], cut1.getOrDefault(topping[i],0)+1);
        }
        
        //하나씩 잘라보기
        for(int i=0; i<n-1; i++) {
            cut1.put(topping[i], cut1.get(topping[i])-1);
            if(cut1.get(topping[i])==0) cut1.remove(topping[i]);
            cut2.put(topping[i], cut2.getOrDefault(topping[i],0)+1);
            if(cut1.size() == cut2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}