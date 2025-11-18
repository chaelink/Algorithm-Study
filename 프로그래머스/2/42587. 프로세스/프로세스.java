import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        //현재 우선순위를 계속 체크
        //해시셋으로 우선순위 중복 제거하고 취합 -> 배열 내림차순 정렬
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<priorities.length; i++) {
            set.add(priorities[i]);
        }
        List<Integer> pro = new ArrayList<>();
        // for(int i : set) {
        //     pro.add(i);
        // }
        for(int i : priorities) {
            pro.add(i);
        }
        Collections.sort(pro, Collections.reverseOrder());
        int idx = 0;
        
        
        //큐에서 빼서 출력 or 다시 넣기
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }
        
        while(!q.isEmpty()) {
            int[] now = q.remove();
            if(now[1] == pro.get(idx)) {
                answer++;
                idx++;
                //인덱스가 로케이션이면 우선순위 리턴하고 끝
                if(now[0] == location) {
                    return answer;
                }
            } else {
                q.add(now);
            }
        }  
        
        return answer;
    }
}