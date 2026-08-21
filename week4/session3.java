writing efficent code o(n)
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 2};

        HashSet<Integer> set = new HashSet<>();

        boolean duplicate = false;

        for (int x : arr) {

            if (set.contains(x)) {
                duplicate = true;
                break;
            }

            set.add(x);
        }

        System.out.println(duplicate);
    }
}
output:
True
