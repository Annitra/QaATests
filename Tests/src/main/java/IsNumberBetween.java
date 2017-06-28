import java.util.regex.Pattern;

/**
 * Created by User on 28.06.2017.
 */
public class IsNumberBetween {
    public static void main(String[] args) {
      String input ="Numbers: 5248,3475,10000,4999";
        System.out.println(isNumberBetween(input));
    }

    public static boolean isNumberBetween(String input) {
        return Pattern.matches("^(?:Numbers: )?(?:(?:[2-9][0-9]{3}|10000)(?:\\.\\d\\d)?(?:,|$))+$", input);
    }
}
