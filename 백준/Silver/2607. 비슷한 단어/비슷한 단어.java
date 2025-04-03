import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];

        String s = br.readLine();
        StringBuilder first = new StringBuilder(s);

        for(int i=0; i<first.length(); i++) {
            char c = first.charAt(i);
            alpha[c- 'A']++;

        }
        int similar = 0;

        for (int i = 1; i < n; i++) {
            String ss = br.readLine();
            StringBuilder sb = new StringBuilder(ss);
            int[] alpha2 = new int[26];
            for(int j=0; j<sb.length(); j++) {
                char cc = sb.charAt(j);
                alpha2[cc - 'A']++;
            }
            int count = 0;
            for(int j=0; j<alpha.length; j++) {
                count += Math.abs(alpha[j]-alpha2[j]);
            }
            if(count<=2 && Math.abs(first.length() - sb.length())<=1) {
                similar++;
            }
            
        }
        System.out.println(similar);
    }
}
