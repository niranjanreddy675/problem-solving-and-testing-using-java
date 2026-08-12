import java.util.Arrays;
import java.util.List;

public class reduces {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 45, 25, 80, 35, 60);

        int largest = numbers.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);

        System.out.println("Largest number = " + largest);
    }
}