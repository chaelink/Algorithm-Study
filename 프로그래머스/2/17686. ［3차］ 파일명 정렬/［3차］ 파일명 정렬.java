import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        // 파일명을 HEAD, NUMBER, TAIL 기준으로 정렬하기 위해
        // 파일명 전체를 FileInfo 객체로 변환 후 정렬
    
        // FileInfo 리스트 생성
        List<FileInfo> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(parse(files[i], i));  // index는 입력 순서를 보존하기 위한 값
        }

        // 정렬 시작
        Collections.sort(list, (a, b) -> {
            // 1. HEAD 사전순 비교 (대소문자 구분 X)
            int headCompare = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if (headCompare != 0) return headCompare;

            // 2. NUMBER 숫자 크기 비교
            int numA = Integer.parseInt(a.number);
            int numB = Integer.parseInt(b.number);
            if (numA != numB) return numA - numB;

            // 3. 입력 순서(index) 유지
            return a.index - b.index;
        });

        // 정렬된 결과를 문자열 배열로 복원
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            FileInfo f = list.get(i);
            answer[i] = f.head + f.number + f.tail;
        }

        return answer;
    }

    // 파일명을 HEAD / NUMBER / TAIL로 분리하는 함수
    private FileInfo parse(String s, int index) {
        int idx = 0;

        // 1) HEAD 찾기: 숫자가 나오기 전까지 HEAD
        while (idx < s.length() && !Character.isDigit(s.charAt(idx))) {
            idx++;
        }
        String head = s.substring(0, idx);

        // 2) NUMBER 찾기: 숫자가 시작된 후 최대 5자리
        int start = idx;
        while (idx < s.length() && Character.isDigit(s.charAt(idx)) && idx - start < 5) {
            idx++;
        }
        String number = s.substring(start, idx);

        // 3) 나머지 TAIL
        String tail = "";
        if (idx < s.length()) {
            tail = s.substring(idx);
        }

        return new FileInfo(head, number, tail, index);
    }

    // HEAD / NUMBER / TAIL / 입력순서 정보를 담는 클래스
    class FileInfo {
        String head;
        String number;
        String tail;
        int index;

        public FileInfo(String head, String number, String tail, int index) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.index = index;
        }
    }
}
