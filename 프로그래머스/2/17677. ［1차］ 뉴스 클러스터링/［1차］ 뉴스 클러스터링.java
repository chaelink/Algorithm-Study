import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 대문자 통일
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // str1 쪼개기
        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                list1.add("" + a + b);
            }
        }

        // str2 쪼개기
        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                list2.add("" + a + b);
            }
        }

        // 다중집합 → map으로 카운팅
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String s : list1) map1.put(s, map1.getOrDefault(s, 0) + 1);
        for (String s : list2) map2.put(s, map2.getOrDefault(s, 0) + 1);

        // 교집합, 합집합 계산
        int inter = 0, union = 0;

        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);
            inter += Math.min(c1, c2);
            union += Math.max(c1, c2);
        }

        // 특수 케이스: 둘 다 공집합이면 유사도 1
        if (union == 0) return 65536;

        double jaccard = (double) inter / union;
        return (int)(jaccard * 65536);
    }
}
