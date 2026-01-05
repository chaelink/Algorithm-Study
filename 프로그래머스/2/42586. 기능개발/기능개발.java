import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        //현재 진도, 개발 속도
        int n = speeds.length;
        int idx = 0;
        while(idx < n) {
            if(progresses[idx]>=100) {
                int count = 0;
                for(int i=idx; i<n; i++) {
                    if(progresses[i]>=100) {count++;}
                    else {
                        break;}
                }
                answer.add(count);
                idx += count;
            } else {
                while(progresses[idx]<100) {
                    for(int i=idx; i<n; i++) {
                        progresses[i] += speeds[i];
                    }
                }
            }
        }
       
//         while (idx < n) {
//             // 하루 단위 진도 증가
//             for (int i = idx; i < n; i++) {
//                 progresses[i] += speeds[i];
//             }

//             // 연속된 배포 가능한 기능 세기 
//             int count = 0;
//             for (int i = idx; i < n; i++) {
//                 if (progresses[i] >= 100) { //idx==현재 가장 앞 기능의 인덱스
//                     count++;
//                 } else {
//                     break; // 앞에서부터 연속된 것만 체크해야 하므로 바로 break
//                 }
//             }

//             if (count > 0) {
//                 answer.add(count);
//                 idx += count; //완료된 만큼 인덱스 증가           }
//         }
        
        return answer;
    }
}