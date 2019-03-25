import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




import java.io.File;

import static org.junit.Assume.assumeTrue;

public enum BrowsersFactory {
    chrome {
        public  WebDriver create(){
            updateProperty("chrome");
            return  new ChromeDriver();
        }
    },
    firefox{
        public WebDriver create(){
            updateProperty("firefox");
            return new FirefoxDriver();
        }
    };

    public WebDriver create(){
        return null;
    }

    void updateProperty(String browserName) {
        System.out.println(String.format("\nstarting %s-browser......", browserName));
        if (System.getProperty("browser") == null) System.setProperty("browser", browserName);
    }
}
