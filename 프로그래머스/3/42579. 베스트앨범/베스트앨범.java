import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        List<Integer> answer = new ArrayList<>();
        int n = plays.length;
       
        //장르, 고유번호 목록
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            List<Integer> list = map.getOrDefault(genres[i], new ArrayList<>());
            list.add(i);
            map.put(genres[i], list);
        }
        
        //횟수, 장르
        Map<Integer, String> gen = new HashMap<>();
        
        List<Integer> dev = new ArrayList<>();
        
        for( Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Integer> list = entry.getValue();
            int count = 0;
            for(int i=0; i<list.size(); i++) {
                count += plays[list.get(i)];
            }
            gen.put(count, name);
            dev.add(count);
        }
        
        //장르 내림차순 정렬
        Collections.sort(dev, Collections.reverseOrder());
        
        //계산
        for(int i=0; i<dev.size(); i++) {
            String name = gen.get(dev.get(i));
            List<Integer> list = map.get(name);
            if(list.size()==1) {
                answer.add(list.get(0));
            } else {
                Map<Integer, Integer> li = new HashMap<>();
                for(int q=0; q<list.size(); q++) {
                    li.put(list.get(q), plays[list.get(q)]);
                }
                List<Map.Entry<Integer, Integer>> cho = new ArrayList<>(li.entrySet());
                cho.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
                answer.add(cho.get(0).getKey());
                answer.add(cho.get(1).getKey());
            }
        }
        int[] ans = new int[answer.size()];
        int idx = 0;
        for(int i : answer) {
            ans[idx] = i;
            idx++;
        }
        
        return ans;
    }
}