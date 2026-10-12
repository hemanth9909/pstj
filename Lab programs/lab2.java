
import java.util.*;
import java.util.stream.*;

public class RealTimeStreamAnalytics {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        IntSummaryStatistics stats =
            Arrays.stream(numbers).summaryStatistics();

        System.out.println("Total Elements: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Minimum: " + stats.getMin());
        System.out.println("Maximum: " + stats.getMax());

        List<Integer> evenNumbers = Arrays.stream(numbers)
            .filter(n -> n % 2 == 0)
            .boxed()
            .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evenNumbers);
    }
}
Total Elements: 5
Sum: 150
Average: 30.0
Minimum: 10
Maximum: 50
Even Numbers: [10, 20, 30, 40, 50]
