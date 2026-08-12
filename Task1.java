import java.util.*;
import java.util.stream.Collectors;

public class Taskl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> salaries = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            salaries.add(sc.nextInt());
        }

        List<Integer> updatedSalaries = salaries.stream()
                .map(salary -> salary + (salary * 10 / 100))
                .collect(Collectors.toList());

        updatedSalaries.forEach(salary -> System.out.print(salary + " "));



        sc.close();
    }
}



output:
5
1000
2000
3000
4000
5000
1100 2200 3300 4400 5500 
