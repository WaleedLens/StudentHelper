package core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import service.FlightSearchService;
import service.SeleniumService;

import java.util.List;

public class FlightSearchTest {
    ChromeDriver chd = new SeleniumService().getChromeDriver();
    FlightSearchService flightSearch = new FlightSearchService(chd);


    /**
     * Check if it fetched prices.
     */
    @Test
    void getFlightsPriceTest() {
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
        List<WebElement> wb = chd.findElements(By.className("tPgKwe"));
        //System.out.println(wb.getText());
        //String timeInterval = wb.getText().replaceAll("\\s","").replaceAll("-","").replaceAll("\\s","");
        for(WebElement e : wb){
            String timeInterval = e.getText().replaceAll("\\s","").replaceAll("-","").replaceAll("\\s","");

            if(timeInterval.matches("^[0-9]+:[0-9]+.(PM|AM|am|pm).[0-9]+:[0-9]+.(PM|AM|am|pm)$")) {
                System.out.println(e.getText().replaceAll("\n",""));
            }
        }

       //Assertions.assertTrue(timeInterval.matches("^[0-9]+:[0-9]+.(PM|AM|am|pm).[0-9]+:[0-9]+.(PM|AM|am|pm)$"));
    }

    @Test
    void getFlightStopsIfAnyTest(){
        flightSearch.googleFlightOneWay("JED", "DMM", 2023, 5, 3, 2);
        List<WebElement> wb = chd.findElements(By.className("rGRiKd"));

        for(WebElement e: wb) {
            String flightCarrier = e.getAttribute("outerHTML").replaceAll("<span>", "").replaceAll("</span>", "").replaceAll("<span class=\"h1fkLb\">", "");
            System.out.println(flightCarrier.contains("stop") + " Original: " +flightCarrier);
        }
    }


}
