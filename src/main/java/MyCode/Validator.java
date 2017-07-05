package MyCode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 01.07.2017.
 */
public class Validator {
    private String patterNumbers = "^(?:Numbers: )?(?:(?:[2-9][0-9]{3}|10000)(?:\\.\\d\\d)?(?:,|$))+$";
    private String patterEmails = "^(?i)(?:(?:[^@]+@gmail\\.com)(?:,|$))+$";
    private String patterZamena = "(?i)ukr\\.net|yandex\\.ru|yahoo\\.com|mail\\.ru";
    String output;

    public Validator(){

    }
    public boolean numbers(String input) {
        return Pattern.matches(this.patterNumbers, input);
    }
    public boolean emails(String input)
    {
        return Pattern.matches(this.patterEmails, input);
    }
    public   String zamena(String input){
        String newPart = "gmail.com";
        String output = "";

        return output = input.replaceAll(this.patterZamena, newPart);
    }
}
