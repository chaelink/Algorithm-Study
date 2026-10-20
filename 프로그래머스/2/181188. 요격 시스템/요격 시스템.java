// import java.util.*;

// class Solution {
//     public int solution(int[][] targets) {
//         Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

//         int answer = 0;
//         int end = 0;

//         for (int[] target : targets) {
//             if (target[0] >= end) {
//                 answer++;
//                 end = target[1];
//             }
//         }

//         return answer;
//     }
// }

import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        int n = targets.length;
       
        int idx = 0;
        int now = 0;
        while(idx<n) {
            //현재 시간은 인덱스 끝 시간
            now = targets[idx][1];
            
            int num = 0;
            //다음 인덱스 시작시간이 < 현재면 추가
            for(int i=idx+1; i<n; i++) {
                if(targets[i][0]<now) {
                    num++;
                } else {break;}
            }
            
            //인덱스 갱신
            idx += (num+1);
            answer++;
        }
        
        return answer;
    }
}