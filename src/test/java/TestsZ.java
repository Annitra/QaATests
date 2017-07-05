import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import MyCode.Validator;

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
public class TestsZ {
    Validator myValidator;

    @DataProvider(name = "TestData")
    public Object[][] createData(){
        return new Object[][] {
                 {"email1@gmail.com,email2@ukr.net", "email1@gmail.com,email2@gmail.com"},
                 {"email@gmail.com,email2@ukr.net,email3@yandex.ru", "email@gmail.com,email2@gmail.com,email3@gmail.com"},
                 {"email@yandex.ru,email2@yahoo.com,email3@ukr.net,email4@mail.ru", "email@gmail.com,email2@gmail.com,email3@gmail.com,email4@gmail.com"},
                 {"email@YAHOO.com", "email@gmail.com"},
                 {"email1@ukr.net,email2@ukr.net,email3@ukr.net", "email1@gmail.com,email2@gmail.com,email3@gmail.com"}

        };
    }
    @BeforeTest
    void setUp(){
        System.out.println("Created Object");
        myValidator = new Validator();
    }

    @Test(dataProvider = "TestData", description = "Test for changing all nongmail-emails")
    void TestsIsGmail(String testString, String expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (String) myValidator.zamena(testString), expectedResult,"Bad input " + testString);
    }
    @AfterMethod
    void afterM(ITestResult testResult){
        System.out.println(testResult.isSuccess());
        System.out.println(testResult.getMethod().getDescription());
    }
}
