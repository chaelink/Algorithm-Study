import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        String bin = Long.toBinaryString(n);
        String binary = new StringBuilder(bin).reverse().toString();
        long answer = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if(i==0) {
                    answer += 1;
                } else {
                    long sum = 1;
                    for(int j=0; j<i; j++) {
                        sum *=3;
                    }
                    answer += sum;
                }
            }
        }
        System.out.println(answer);

    }
}
