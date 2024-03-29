import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int i = 0;
        for (i = 0; i < (c.length - 2); i ++){
            if (c[i+1] == 0 && c[i+2] == 0){
                i ++;
                jumps ++;
            } else if (c[i+1] == 0 && c[i+2] == 1){
                jumps ++;
            } else if (c[i+1] == 1 && c[i+2] == 0){
                jumps ++;
                i ++;
            } else if (c[i+1] == 1 && c[i+2] == 1){
                jumps = -1;
            }
        }
        if (i == c.length - 2){
            if (c[i+1] == 0){
                jumps ++;
            }
        } 
        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
