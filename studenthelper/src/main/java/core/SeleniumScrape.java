package core;

import core.utils.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScrape {
    private ChromeDriver chromeDriver;

    public SeleniumScrape(){
        System.setProperty("webdriver.chrome.driver", FileUtils.getResourcesPath()+"chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }


    public ChromeDriver getChromeDriver(){
        return this.chromeDriver;
    }

    public void setChromeDriver(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
    }





}
