Day of Week:
code:
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);

        return date.getDayOfWeek()
                   .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}
OUTPUT:
Input
day =
31
month =
8
year =
2019
Output
"Saturday"
