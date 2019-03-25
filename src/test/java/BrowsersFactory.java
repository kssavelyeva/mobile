import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

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
    },
    opera {
        public WebDriver create(){
            System.setProperty("webdriver.opera.driver","C:\\Users\\Карина\\Desktop\\operadriver_win64\\operadriver.exe");
            OperaOptions options = new OperaOptions();
            options.setBinary("C:\\Users\\Карина\\AppData\\Local\\Programs\\Opera\\58.0.3135.118_0\\opera.exe");
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            updateProperty("opera");
            return new OperaDriver(capabilities);
        }
    }
    ;

    public WebDriver create(){
        return null;
    }

    void updateProperty(String browserName) {
        System.out.println(String.format("\nstarting %s-browser......", browserName));
        if (System.getProperty("browser") == null) System.setProperty("browser", browserName);
    }
}
