import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        
        //중복 신고 제거
        HashSet<String> report2 = new HashSet<>();
        for(int i=0; i<report.length; i++) {
            report2.add(report[i]);
        }
        
        //이름 번호 연결
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(id_list[i],i);
        }
        
        HashMap<String, List<String>> count = new HashMap<>();
        
        //이름, 신고한사람 목록 표
        for(String sen : report2) {
            String[] s = sen.split(" ");
            if(count.containsKey(s[1])) {
                List<String> to = count.get(s[1]);
                to.add(s[0]);
                count.put(s[1], to);
            } else {
                List<String> to = new ArrayList<>();
                to.add(s[0]);
                count.put(s[1],to);
            }
        }
        
        //이름 별 신고한 사람 수가 k 이상이면 그 사람들 인덱스 증가
        for(String name : count.keySet()) {
            List<String> plus = count.get(name);
            if(plus.size()>=k) {
                for(int i=0; i<plus.size(); i++) {
                    int idx = map.get(plus.get(i));
                    answer[idx]++;
                }
            }
        }
        
        return answer;
    }
}