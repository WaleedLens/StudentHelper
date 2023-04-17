package core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FlightSearchTest {
    ChromeDriver chd = new SeleniumScrape().getChromeDriver();
    FlightSearch flightSearch = new FlightSearch(chd);


    /**
     * Check if it fetched prices.
     */
    @Test
    void getFlightsPricesTest() {
        flightSearch.googleFlightOneWay("JED", "DMM", 2023, 5, 3, 2);
        WebElement wb = chd.findElement(By.ByClassName.className("BVAVmf"));
        Assertions.assertTrue(wb.getText().contains("SAR"), wb.getText());
        Assertions.assertTrue(wb.getText().matches("[A-Za-z]+\\s[0-9]+"), wb.getText());
    }

    @Test
    void getFlightsCarrierTest() {
        flightSearch.googleFlightOneWay("JED", "DMM", 2023, 5, 3, 2);
        WebElement wb = chd.findElement(By.className("h1fkLb"));
        String flightCarrier = wb.getAttribute("outerHTML").replaceAll("<span>", "").replaceAll("</span>", "").replaceAll("<span class=\"h1fkLb\">", "");
        Assertions.assertTrue(flightCarrier.matches("[A-Za-z]+"),flightCarrier);


        //  (wb.getText().matches(""),wb.getText());
    }
    @Test
    void getFlightTimeIntervalTest(){
        flightSearch.googleFlightOneWay("JED", "DMM", 2023, 5, 3, 2);
        WebElement wb = chd.findElement(By.className("tPgKwe"));
        System.out.println(wb.getText());
    }
}
