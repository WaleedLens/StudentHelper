package core;

import core.utils.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumScrape {
    private ChromeDriver chromeDriver;

    public SeleniumScrape(){
        System.setProperty("webdriver.chrome.driver", FileUtils.getResourcesPath()+"chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        chromeDriver = new ChromeDriver(options);

    }


    public ChromeDriver getChromeDriver(){
        return this.chromeDriver;
    }

    public void setChromeDriver(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
    }





}
