import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            Stack<Integer> st = new Stack<>();
            String s = br.readLine();
            String[] word= s.split(" ");
            
            System.out.print("Case #"+(i+1)+": ");
            for(int j=word.length-1; j>=0; j--) {
                System.out.print(word[j]+" ");
            }
            System.out.println();
        }
    }
}