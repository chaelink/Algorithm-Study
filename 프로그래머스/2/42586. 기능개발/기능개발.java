import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        int n = progresses.length;
        //각 기능의 개발속도는 다름
        //100개 이하
        //
        int i = 0;
        while(i<n) {
            int temp = 0;
            for(int i2=i; i2<n; i2++) {
                progresses[i2] += speeds[i2];
            }
            for(int i2=i; i2<n; i2++) {
                if(progresses[i2]>=100) {
                    temp++;
                } else {
                    break;
                }
            }
            if(temp>0) {
                list.add(temp);
                i += temp;
            }
        }
        
        int[] answer = new int[list.size()];
        int a = 0;
        for(int num :list) {
            answer[a] = num;
            a++;
        }
        
        
        return answer;
    }
}