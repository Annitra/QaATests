import java.util.regex.Pattern;

/**
 * Created by User on 28.06.2017.
 */
public class IsGmail {
    public static void main(String[] args) {
        String input="email1@gmail.com,email2@gmail.com,email3@gmail.com, email4@gmail.com";
        System.out.println(isGmail(input));
    }
    public static boolean isGmail(String input)
    {
        return Pattern.matches("^(?i)(?:(?:[^@]+@gmail\\.com)(?:,|$))+$", input);
    }
}
