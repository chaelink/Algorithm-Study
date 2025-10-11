class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        long pNum = Long.parseLong(p);
        int count = 0;

        for (int i = 0; i <= t.length() - len; i++) {
            long num = Long.parseLong(t.substring(i, i + len));
            if (num <= pNum) count++;
        }

        return count;
    }
}
