import java.io.*;
import java.util.*;

public class Main {
    static int[] current = new int[4];
    static int[] required = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] str = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        // 초기 윈도우
        for (int i = 0; i < p; i++) {
            if(str[i] == 'A') current[0]++;
            if(str[i] == 'C') current[1]++;
            if(str[i] == 'G') current[2]++;
            if(str[i] == 'T') current[3]++;
        }

        if(checkDna()) {
            answer++;
        }

        // 슬라이딩 윈도우
        for (int j = p; j < s; j++) {
            int i = j - p;
            // 빠지는 문자
            if(str[i] == 'A') current[0]--;
            if(str[i] == 'C') current[1]--;
            if(str[i] == 'G') current[2]--;
            if(str[i] == 'T') current[3]--;

            // 새로 들어오는 문자
            if(str[j] == 'A') current[0]++;
            if(str[j] == 'C') current[1]++;
            if(str[j] == 'G') current[2]++;
            if(str[j] == 'T') current[3]++;

            if(checkDna()) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean checkDna() {
        for (int i = 0; i < 4; i++) {
            if(current[i] < required[i]) return false;
        }
        return true;
    }
}
