import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        int idx = 0;
        Stack<String[]>st = new Stack<>();
        
        //1. plans를 인덱스1 기준으로 정렬(시작 시간이 빠른 순)
        Arrays.sort(plans, (a,b) -> a[1].compareTo(b[1]));
        // for(String[] str : plans) {
        //     System.out.println(str[1]);
        // }
        
        
        //지금 시간 = 0번 인덱스 시작 시간
        String nowtime = plans[0][1];
        
        //2. n까지 for문 순회
        for(int i=1; i<n; i++) {
            int time = cal(plans[i][1]) - cal(nowtime);
            int before = Integer.parseInt(plans[i-1][2]);
            //현재 시간 - 이전 인덱스 시작시간 >= 이전 작업시간이면, 완료-> 정답에 담기
            if(time >= before) {
                answer[idx] = plans[i-1][0];
                idx++;
                time -= before;
                //남는 시간 + 스택 비어있지않으면 작업, 완료이거나 다시 스택에 추가
                while(time>0 && !st.isEmpty()) {
                    String[] job = st.pop();
                    int t = Integer.parseInt(job[1]);
                    if(time-t>=0) {
                        answer[idx] = job[0]; idx++;
                        time -= t;
                    } else {
                        st.push(new String[]{job[0], (t-time)+""});
                        time=0;
                    }
                }
            } else {
                //아직 미완료면 미완료 시간 스택에 추가
                st.push(new String[]{plans[i-1][0], (before-time)+""});
            }
            nowtime = plans[i][1];
        }
        
        //for문이 끝난 후 마지막 인덱스는 자동 완료
        answer[idx] = plans[n-1][0];
        idx++;
        
        //for문 이후 스택 남아있으면
        while(!st.isEmpty()) {
            String[] str = st.pop();
            answer[idx] = str[0];
            idx++;
        }
        
        return answer;
    }
    
    int cal(String str) {
        String[] s = str.split(":");
        return Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
    }
}