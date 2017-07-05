import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import MyCode.Validator;
/**
 * Created by User on 01.07.2017.
 */

 /*               Positive:
          *          2000 : True
          *          10000 : True
          *          Numbers: 2000 : True
          *          2000,5000 : True
          *          6000.10 : True
          *          7000,6000,2000,4000 : True
          *          2000, : True
          *
          *      Negative:
          *          6000,1 : False
          *          4000.1  : False
          *          10001 : False
          *          1999 : False
          *          */

public class Tests {
    Validator myValidator;

    @DataProvider(name = "TestData")
    public Object[][] createData(){
        return new Object[][] {
                {"6000", Boolean.TRUE},
                {"6000,1", Boolean.FALSE},
                {"6000,10000", Boolean.TRUE},
                {"6000.10", Boolean.TRUE}
        };
    }
    @BeforeTest
    void setUp(){
        System.out.println("Created Object");
        myValidator = new Validator();
    }

    @Test(dataProvider = "TestData", description = "Test for Numbers Validation")
    void Positive(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) myValidator.numbers(testString), expectedResult,"Bad input " + testString);
    }

    @AfterMethod
    void afterM(ITestResult testResult){
        System.out.println(testResult.isSuccess());
        System.out.println(testResult.getMethod().getDescription());
    }
 //   @Parameters({"input"}) //nazvanij iz xml-file
   /* @Test
    public static void Test1(String testString) {
        Assert.assertTrue(Validator.isNumberBetween(testString),"Bad input "+testString); // assert proverit chto vernet True
    }*/
    /*@Test
    public static void Test2() {
        Assert.assertTrue(Validator.isNumberBetween("10000"));
    }
   /* @Test
    public static void Test3() {
        IsNumberBetween.isNumberBetween("Numbers: 2000");
    }
    @Test
    public static void Test4() {
        IsNumberBetween.isNumberBetween("2000,5000");
    }
    @Test
    public static void Test5() {
        IsNumberBetween.isNumberBetween("6000.10");
    }
    @Test
    public static void Test6() {
        IsNumberBetween.isNumberBetween("7000,6000,2000,4000");
    }
    @Test
    public static void Test7() {
        IsNumberBetween.isNumberBetween("2000,");
    }*/
    /*
    @Test
    public static void Test8() {
        Assert.assertFalse(Validator.isNumberBetween("6000,1"));
    }
   /* @Test
    public static void Test9() {
        IsNumberBetween.isNumberBetween("4000.1");
    }
    @Test
    public static void Test10() {
        IsNumberBetween.isNumberBetween("10001");
    }
    @Test
    public static void Test11() {
        IsNumberBetween.isNumberBetween("1999");
    }*/

}
