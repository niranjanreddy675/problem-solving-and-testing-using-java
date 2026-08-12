import java.util.Arrays;
import java.util.List;

public class streams {
    public static void main(String[] args) {

        List<String> students = Arrays.asList(
                "Niranjan", "Rahul", "Priya", "Arun", "Sneha"
        );

        students.stream()
                .forEach(name -> System.out.println(name));
    }
}