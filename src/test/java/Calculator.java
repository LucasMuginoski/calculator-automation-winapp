import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Calculator {

    private WindowsDriver calcsession = null;
    private WebElement calcresult = null;
    private CalcPO calc = null;

    @BeforeClass
    public void setUp(){
        System.out.println("Set Up");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        try {
            calcsession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            calc = new CalcPO(calcsession);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    @BeforeMethod
    public void clear(){
        System.out.println("Clear");
        calcsession.findElementByName("Limpar").click();
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Tear down!");
        calcsession.quit();
    }

    @Test
    public void addition(){
        System.out.println("Running Addition");
        calc.One().click();
        calc.Two().click();
        calc.Plus().click();
        calc.Nine().click();
        calc.Equals().click();
        Assert.assertEquals(calc.getDisplayResult(), "21");

    }

    @Test
    public void multiplication(){
        System.out.println("Running Multiplication");
        calc.Three().click();
        calc.Three().click();
        calc.Multiply().click();
        calc.Two().click();
        calc.Equals().click();
        Assert.assertEquals(calc.getDisplayResult(), "66");
    }

    @Test
    public void subtraction(){
        System.out.println("Running Subtraction");
        calc.One().click();
        calc.Two().click();
        calc.Minus().click();
        calc.Nine().click();
        calc.Equals().click();
        Assert.assertEquals(calc.getDisplayResult(), "3");
    }

    @Test
    public void division(){
        System.out.println("Running Division");
        calc.Three().click();
        calc.Four().click();
        calc.Division().click();
        calc.Two().click();
        calc.Equals().click();
        Assert.assertEquals(calc.getDisplayResult(), "17");
    }


    public void chooseCalculator(String locator){
        System.out.println(locator);
        calcsession.findElementByAccessibilityId("TogglePaneButton").click();
        List <WebElement> listOfElements = calcsession.findElementsByClassName("Microsoft.UI.Xaml.Controls.NavigationViewItem");
        System.out.println(listOfElements.size());
        for(int i=0; i < listOfElements.size(); i++){
            if (listOfElements.get(i).getAttribute("Name").equals(locator)){
                listOfElements.get(i).click();
                break;
            }

        }
    }
}