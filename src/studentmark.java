import java.util.*;

public class studentmark {
    public static void main(String[] args) {

        List<Integer> marks = Arrays.asList(45, 78, 62, 90, 55, 81, 38);

        marks.stream()
                .filter(mark -> mark >= 50)
                .map(mark -> mark + 5)
                .forEach(mark -> System.out.println(mark));
    }
}
