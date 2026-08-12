import java.util.*;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int maxEndingHere = sc.nextInt();
        int maxSoFar = maxEndingHere;

        for (int i = 1; i < n; i++) {
            int value = sc.nextInt();

            maxEndingHere = Math.max(value, maxEndingHere + value);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        System.out.println(maxSoFar);

        sc.close();
    }
}