import java.util.*;
class Solution {
    int end;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int n = minerals.length;
        int sum =0;
        for(int a : picks) {sum +=a;}
        
        //1. 리스트에 돌 곡괭이 기준 5구간 피로도 합 저장(시작인덱스, 피로도 합)
        //1-1. 곡괭이 수가 더 적어 모든 광물을 캘 수 없다면, 곡괭이 수만큼만 구간 저장
        end = Math.min(sum*5,n);
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<end; i+=5) {
            int num=0;
            for(int j=i; j<Math.min(end,i+5); j++) {
                if(minerals[j].equals("diamond")) {num+=25;}
                else if(minerals[j].equals("iron")){num+=5;}
                else {num+=1;}
            }
            list.add(new int[]{i,num});
        }
         
        //2. 피로도합 값이 크다 -> 다이아몬드가 많으니 더 좋은 곡괭이 사용해야한다 
        //3. 리스트 정렬 -> 앞에서부터 좋은 곡괭이 할당
        Collections.sort(list, (a,b) -> b[1]-a[1]);
        
        //곡괭이 -> 무조건 5개 순서대로
        for(int[] a : list) {
            for(int i=0; i<3; i++) {
                if(picks[i]>0) {
                    //피로도 계산
                    answer += cal(a[0],i,minerals);
                    picks[i]--;
                    break;
                }
            }
        } 
        return answer;
    }
    
    int cal(int idx, int p, String[] minerals) {
        int num=0;
        if(p==0) {
            for(int i=idx; i<Math.min(idx+5, end); i++) {
              num+=1;   
            }
        } else if(p==1) {
            for(int i=idx; i<Math.min(idx+5, end); i++) {
               if(minerals[i].equals("diamond")) {num+=5;} 
                else {num+=1;}
            }
        } else {
            for(int i=idx; i<Math.min(idx+5, end); i++) {
                if(minerals[i].equals("diamond")) {num+=25;}
                else if(minerals[i].equals("iron")){num+=5;}
                else {num+=1;}
            }
        }
        return num;
    }
}