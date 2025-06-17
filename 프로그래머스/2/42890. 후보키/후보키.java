import java.util.*;

class Solution {
    List<Set<Integer>> keys = new ArrayList<>();   //개수가 1인 후보키 인덱스 목록
    
    public int solution(String[][] relation) {
        int answer = 0;
        int column = relation[0].length;
        int n = relation.length;
        
        for(int i=1; i<=column; i++) {
            dfs(0,new ArrayList<>(), i, relation);
        }
        
        answer = keys.size();
        return answer;
    }
    
    public void dfs(int idx, List<Integer> comb, int size, String[][] relation) {
        if(comb.size() == size) {
            if(isMinimal(comb) && isUnique(comb, relation)) {
                keys.add(new HashSet<>(comb));
            }
            return;
        }
        
        for(int i=idx; i<relation[0].length; i++) {
            comb.add(i);
            dfs(i+1, comb, size, relation);
            comb.remove(comb.size()-1);
        }
        
    }
    
    public boolean isMinimal(List<Integer>comb) {
        for(Set<Integer> key : keys) {
            if(comb.containsAll(key))
                return false;
        }
        return true;
    }
    
    public boolean isUnique(List<Integer> comb, String[][] relation) {
        Set<String> tuples = new HashSet<>();
        
        for(String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for(int col : comb) {
                sb.append(row[col]).append(",");
            }
            tuples.add(sb.toString());
        }
        return tuples.size() == relation.length;
    }
}
