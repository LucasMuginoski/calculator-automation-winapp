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

    @BeforeClass
    public void setUp(){
        System.out.println("Set Up");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        try {
            calcsession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
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
        calcsession.findElementByName("Um").click();
        calcsession.findElementByName("Dois").click();
        calcsession.findElementByName("Mais").click();
        calcsession.findElementByName("Nove").click();
        calcsession.findElementByName("Igual a").click();
        Assert.assertEquals(getDisplayResult(), "21");

    }

    @Test
    public void multiplication(){
        System.out.println("Running Multiplication");
        calcsession.findElementByName("Três").click();
        calcsession.findElementByName("Três").click();
        calcsession.findElementByName("Multiplicar por").click();
        calcsession.findElementByName("Dois").click();
        calcsession.findElementByName("Igual a").click();
        Assert.assertEquals(getDisplayResult(), "66");
    }

    @Test
    public void subtraction(){
        System.out.println("Running Subtraction");
        calcsession.findElementByName("Um").click();
        calcsession.findElementByName("Dois").click();
        calcsession.findElementByName("Menos").click();
        calcsession.findElementByName("Nove").click();
        calcsession.findElementByName("Igual a").click();
        Assert.assertEquals(getDisplayResult(), "3");
    }

    @Test
    public void division(){
        System.out.println("Running Division");
        calcsession.findElementByName("Três").click();
        calcsession.findElementByName("Quatro").click();
        calcsession.findElementByName("Dividir por").click();
        calcsession.findElementByName("Dois").click();
        calcsession.findElementByName("Igual a").click();
        Assert.assertEquals(getDisplayResult(), "17");
    }
    public String getDisplayResult(){
        calcresult = calcsession.findElementByAccessibilityId("CalculatorResults");
        return calcresult.getText().replace("A exibição é", "").trim();
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

    @Test
    public void selectAnotherCalculator(){
        System.out.println("Selecting another calculator");
        chooseCalculator("Científica Calculadora");
    }

    public void chooseCalculatorByXPath(String locator){
        System.out.println(locator);
        calcsession.findElementByAccessibilityId("TogglePaneButton").click();
        List <WebElement> listOfElements = calcsession.findElementsByXPath("//ListItem");
        System.out.println(listOfElements.size());
        for(int i=0; i < listOfElements.size(); i++){
            if (listOfElements.get(i).getAttribute("Name").equals(locator)){
                listOfElements.get(i).click();
                break;
            }

        }
    }
    @Test
    public void selectAnotherCalculatorXpath(){
        System.out.println("Selecting another calculator");
        chooseCalculatorByXPath("Científica Calculadora");
    }
}
