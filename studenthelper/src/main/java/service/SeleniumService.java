package service;

import core.utils.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumService {
    private ChromeDriver chromeDriver;

    public SeleniumService(){
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
