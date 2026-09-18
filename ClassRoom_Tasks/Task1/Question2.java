import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(45, 78, 32, 90, 65, 88, 40, 95);

        List<Integer> updatedMarks = marks.stream()
                .filter(mark -> mark >= 60)
                .map(mark -> mark + 5)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Marks >= 60: " +
                marks.stream()
                    .filter(mark -> mark >= 60)
                    .toList());

        System.out.println("Updated marks in descending order: " + updatedMarks);

        double average = updatedMarks.stream()
                .mapToInt(mark -> mark)
                .average()
                .orElse(0.0);

        System.out.println("Average of updated marks: " + average);
    }
}
