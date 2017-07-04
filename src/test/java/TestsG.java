import MyCode.RegexTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *              Psitive:
 *  email1@gmail.com,email2@gmail.com, email3@gmail.com : true
 *  email@gmail.com  : true
 *  email@gmail.com,  : true
 *  EMAIL@gmail.com  : true
 *
 *              Negative:
 *  " " : false
 *  email@ukr.net : false
 *  emailgmail.com : false
 *  email1@gmail.com email2@gmail.com  : false
 *  ""  : false
 *
 * Created by User on 04.07.2017.
 */
public class TestsG {
    @DataProvider(name = "TestData")
    public Object[][] createData(){
        return new Object[][] {
                {"email1@gmail.com,email2@gmail.com, email3@gmail.com", Boolean.TRUE},
                {"email@gmail.com", Boolean.TRUE},
                {"email@gmail.com,", Boolean.TRUE},
                {"EMAIL@gmail.com", Boolean.TRUE},
                {" ", Boolean.FALSE},
                {"email@ukr.net", Boolean.FALSE},
                {"emailgmail.com ", Boolean.FALSE},
                {"", Boolean.FALSE},
                {"email1@gmail.com email2@gmail.com", Boolean.FALSE}

        };
    }

    @Test(dataProvider = "TestData")
    public static void TestsIsGmail(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) RegexTest.isGmail(testString), expectedResult,"Bad input " + testString);
    }
}
