import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        //대소문자 무시 적용 필요
        
        //캐시 사이즈는 0이상 최대 30
        //도시는 최대 10만개
        
        //lru 최근가장적게사용된
        //스택(큐) -> 히트 시 삭제가 문제
        //순서를 저장하는 셋 -> 맨 앞의 것 삭제가 문제
        
        //Queue<String> q = new ArrayDeque<>();
        if(cacheSize == 0) return cities.length * 5;

        LinkedHashSet<String> q = new LinkedHashSet<>();
        for(int i=0; i<cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
            if(q.contains(cities[i])) {
                answer += 1;
                q.remove(cities[i]);
                q.add(cities[i]);
                //System.out.println("hit");
            } else {
                if(q.size() < cacheSize) {
                    q.add(cities[i]);
                    answer += 5;
                    //System.out.println("miss empty");
                } else {
                    for(String str : q) {
                        q.remove(str);  //가장 앞의 것 삭제
                        break;
                    }
                    q.add(cities[i]);
                    //System.out.println("miss full");
                    answer += 5;
                }
            }
        }
        return answer;
    }
}