import java.util.*;
import java.util.stream.*;

public class task2 {

    static class Reading {
        String sensorId;
        double temperature;

        Reading(String sensorId, double temperature) {
            this.sensorId = sensorId;
            this.temperature = temperature;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Reading> readings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            double temp = sc.nextDouble();

            readings.add(new Reading(id, temp));
        }

        Map<String, Double> averages = readings.stream()
                .filter(r -> r.temperature > 50)
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ));

        averages.entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .forEach(entry ->
                        System.out.println(entry.getKey() + " " + entry.getValue())
                );

        sc.close();
    }
}
