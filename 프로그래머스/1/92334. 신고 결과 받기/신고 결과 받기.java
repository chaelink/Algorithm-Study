import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        //유저 n명
        int n = id_list.length;
        int answer[] = new int[n];
        //System.out.println(n);
        
        //유저,학번 정리
        HashMap<String, Integer> num = new HashMap<>();
        for(int i=0; i<n; i++) {
            num.put(id_list[i], i);
        }
        
        //report 중복 제거(해시셋?)
        HashSet<String> report2 = new HashSet<>();
        for(int i=0; i<report.length; i++) {
            report2.add(report[i]);
        }
        
        //당한사람 한사람목록 리스트업 (해시맵?)
        HashMap<String, String> cal = new HashMap<>();
        for(String str : report2) {
            //System.out.println(str);
            String[] cut = str.split(" ");
            cal.put(cut[1], cal.getOrDefault(cut[1],"")+cut[0]+" ");
        }
        
        //k이상 신고 계산
        for(Map.Entry<String, String> entry : cal.entrySet()) {
            String[] count = entry.getValue().split(" ");
            if(count.length>=k) {
                for(String name : count) {
                    int idx = num.get(name);
                    answer[idx]++;
                }
            }
        }
        
        return answer;
    }
}