import java.util.*;

class Solution {
    List<List<Character>> list = new ArrayList<>();

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // 1. 열(column) 단위로 리스트 구성 (각 열이 하나의 List)
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        // 아래쪽 블록이 리스트의 앞쪽에 오도록 배치하여 삭제 시 중력이 자연스럽게 적용되도록 함
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                list.get(i).add(board[j].charAt(i));
            }
        }

        while (true) {
            // 삭제할 위치를 표시할 check 배열
            boolean[][] check = new boolean[n][m];
            boolean hasDeleted = false;

            // 2. 2x2 블록 찾기
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = 0; j < list.get(i).size() - 1; j++) {
                    if (can(i, j)) {
                        check[i][j] = true;
                        check[i + 1][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j + 1] = true;
                        hasDeleted = true;
                    }
                }
            }

            if (!hasDeleted) break;

            // 3. 지울 블록 카운트 및 '진짜 삭제' 처리
            // 뒤에서부터(역순) remove 해야 인덱스가 뒤틀리지 않음
            for (int i = 0; i < list.size(); i++) {
                for (int j = list.get(i).size() - 1; j >= 0; j--) {
                    if (check[i][j]) {
                        answer++;
                        list.get(i).remove(j); // 리스트에서 제거하면 위쪽 블록이 자동으로 내려옴!
                    }
                }
            }
        }

        return answer;
    }

    // 2x2 검사 (범위 체크 및 빈칸 '.' 제외 조건 추가)
    boolean can(int i, int j) {
        // 인접한 열의 높이가 다를 수 있으므로 j+1 범위 검증 필수
        if (j + 1 >= list.get(i).size() || j + 1 >= list.get(i + 1).size()) return false;

        char c = list.get(i).get(j);
        
        return c == list.get(i + 1).get(j) &&
               c == list.get(i).get(j + 1) &&
               c == list.get(i + 1).get(j + 1);
    }
}