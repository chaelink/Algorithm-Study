import java.io.*;
import java.util.*;

public class Main {
    public static int getMin(int row, int col, char[][] board ) {
        String[] chess = {"WBWBWBWB", "BWBWBWBW"};
        int count = 0;
        
        for(int i=0; i<8; i++) {
            int nrow = row+i;
            for(int j=0; j<8; j++) {
                int ncol = col+j;
                if(board[nrow][ncol] != chess[nrow%2].charAt(j)){
                    count++;
                }
            }
        }
        return Math.min(count, 64-count);
    }
    
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 행 개수, M: 열 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 체스판 정보 저장
        char[][] board = new char[N][M];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
            
        }
        int resultvalue = Integer.MAX_VALUE;
        for(int i=0; i<=N-8; i++) {
            for(int j=0; j<=M-8; j++) {
                 int result = getMin(i,j,board);
                if(result < resultvalue) {
                resultvalue = result;
                }
            }
        }

        // 결과 출력 예시
        System.out.println(resultvalue);
       
    }
}
