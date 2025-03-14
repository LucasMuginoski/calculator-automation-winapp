import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

public class CalcPO {

    private WindowsDriver driver = null;


    public CalcPO(WindowsDriver wd){
        driver = wd;

    }
    public WebElement One(){
        return driver.findElementByName("Um");
    }
    public WebElement Two(){
        return driver.findElementByName("Dois");
    }
    public WebElement Three(){
        return driver.findElementByName("Três");
    }
    public WebElement Four(){
        return driver.findElementByName("Quatro");
    }
    public WebElement Five(){
        return driver.findElementByName("Cinco");
    }
    public WebElement Six(){
        return driver.findElementByName("Seis");
    }
    public WebElement Seven(){
        return driver.findElementByName("Sete");
    }
    public WebElement Eight(){
        return driver.findElementByName("Oito");
    }
    public WebElement Nine(){
        return driver.findElementByName("Nove");
    }
    public WebElement Plus(){
        return driver.findElementByName("Mais");
    }
    public WebElement Multiply(){
        return driver.findElementByName("Multiplicar por");
    }
    public WebElement Minus(){
        return driver.findElementByName("Menos");
    }
    public WebElement Division(){
        return driver.findElementByName("Dividir por");
    }

    public WebElement Equals(){
        return driver.findElementByName("Igual a");
    }
    public String getDisplayResult(){
        return driver.findElementByAccessibilityId("CalculatorResults").getText().replace("A exibição é", "").trim();
    }

}