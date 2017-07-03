package MyCode;
import java.util.regex.Pattern;

/**
 * Created by User on 01.07.2017.
 */
public class RegexTest {
    public static boolean isGmail(String input)
        {
            return Pattern.matches("^(?i)(?:(?:[^@]+@gmail\\.com)(?:,|$))+$", input);
        }


    public static boolean isNumberBetween(String input) {
        return Pattern.matches("^(?:Numbers: )?(?:(?:[2-9][0-9]{3}|10000)(?:\\.\\d\\d)?(?:,|$))+$", input);
    }
}
