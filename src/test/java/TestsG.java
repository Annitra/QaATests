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
public class TestsG {
    Validator myValidator;

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
    @BeforeTest
    void setUp(){
        System.out.println("Created Object");
        myValidator = new Validator();
    }

    @Test(dataProvider = "TestData", description = "Test for Emails Validation")
     void TestsIsGmail(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) myValidator.emails(testString), expectedResult,"Bad input " + testString);
    }
    @AfterMethod
    void afterM(ITestResult testResult){
        System.out.println(testResult.isSuccess());
        System.out.println(testResult.getMethod().getDescription());
    }
}
