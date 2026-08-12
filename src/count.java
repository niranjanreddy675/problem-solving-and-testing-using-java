import java.util.Arrays;
import java.util.List;

public class count {
    public static void main(String[] args) {

        List<Integer> marks = Arrays.asList(45, 60, 75, 30, 50, 85, 40);

        long count = marks.stream()
                .filter(mark -> mark >= 50)
                .count();

        System.out.println("Students scored 50 or more: " + count);
    }
}