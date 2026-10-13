import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        int K = k;
        list.add(k);
        int n =0;
        //1. 우박수열 구하기
        while(k!=1) {
            if(k%2==0) {
                k /= 2;
            } else {
                k = (k*3 +1);
            }
            list.add(k);
            n++;
        }
        
        //2. 구간별 면적 값 구하기
        double[] arr = new double[n];
        for(int i=0; i<n; i++) {
            int a = list.get(i);
            int b = list.get(i+1);
            if(a>b) {
                int temp = b;
                b = a;
                a = temp;
            }
            double sq = (double)a;
            double tr = (double)(b-a)*0.5;
            arr[i] = sq + tr;
            System.out.println(arr[i]);
        }
      
        //3. 레인지 값 계산
        for(int i = 0; i < ranges.length; i++) {
            int[] r = ranges[i];
            int start = r[0];
            int end = n + r[1]; // r[1]은 0 이하이므로 n + r[1]로 끝 위치 결정

            if(start > end) {
                answer[i] = -1.0; // 시작점이 끝점보다 크면 유효하지 않음
            } else if(start == end) {
                answer[i] = 0.0;  // 면적이 0인 경우 (예: [0, -n] 또는 [n, 0])
            } else {
                for(int j = start; j < end; j++) {
                    answer[i] += arr[j]; // 정상 구간 합 누적
                }
            }    
        }
            
        return answer;
    }
}