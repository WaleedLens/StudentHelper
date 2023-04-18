package core;

import core.utils.PatternUtils;
import model.Flight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightSearch {

    private final ChromeDriver chromeDriver;

    public FlightSearch(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;

    }

    //https://www.google.com/travel/flights?q=Flights%20to%20#AIRPORT_CODE#%20from%20#AIRPORT_CODE#%20on%20#YEAR#-#MONTH#-#DAY#%20through%20#YEAR#-#MONTH#-#DAY#
    //https://www.google.com/travel/flights?q=Flights%20to%20#AIRPORT_CODE#%20from%20#AIRPORT_CODE#%20on%20#YEAR#-#MONTH#-#DAY#%20through%20#YEAR#-#MONTH#-#DAY#
    public List<Flight> getFlights(){


        List<WebElement> wb1 = chromeDriver.findElements(By.className("rGRiKd"));
        System.out.println("Size 2: " + wb1.size());

        List<WebElement> wb2 = chromeDriver.findElements(By.className("h1fkLb"));


        return null;
    }
    private List<Integer> getPrices(){
        List<Integer> prices = new ArrayList<>();
        List<WebElement> wb = chromeDriver.findElements(By.ByClassName.className("BVAVmf"));
        for(WebElement e : wb){
            if(e.getText().contains("SAR")){
                prices.add(PatternUtils.getPriceAsInteger(e.getText()));
            }
        }
        if(prices.size() == 0)
            throw new IllegalStateException("Unable to fetch data");
        return prices;
    }
    private List<String> getTimeIntervals(){
        List<WebElement> wb = chromeDriver.findElements(By.className("wtdjmc"));
        List<String> timeIntervals = new ArrayList<>();
        for(WebElement e : wb){
            String timeInterval = e.getText().replaceAll("\\s","").replaceAll("-","").replaceAll("\\s","");
            if(timeInterval.matches("^[0-9]+:[0-9]+.(PM|AM|am|pm).[0-9]+:[0-9]+.(PM|AM|am|pm)$")) {
                timeIntervals.add(e.getText().replaceAll("\n",""));
            }
        }
        if(timeIntervals.size() == 0)
            throw new IllegalStateException("Unable to fetch data");
        return timeIntervals;
    }




    public void googleFlightOneWay(String fromAirport,String toAirport,int year,int month,int day,int adults){
        String fullDateInString =  String.join("-",String.valueOf(year),String.valueOf(month),String.valueOf(day));
        String countAdults = PatternUtils.getAdultsNumber(adults);
        String oneWayURL = String.join("%20","https://www.google.com/travel/flights?q=Flights","to",toAirport,"from",fromAirport,
                "oneway",fullDateInString,"with",countAdults,"adult");
        chromeDriver.get(oneWayURL);
    }








    public void googleFlightRoundTrip(String fromAirport,String toAirport,int yearStart,int monthStart,int dayStart,
          int adults,int yearEnd,int monthEnd,int dayEnd){

        String fullDateStart =  String.join("-",String.valueOf(yearStart),String.valueOf(monthStart),String.valueOf(dayStart));
        String fullDateEnd =  String.join("-",String.valueOf(yearEnd),String.valueOf(monthEnd),String.valueOf(dayEnd));

        String countAdults = PatternUtils.getAdultsNumber(adults);
        String roundTripURL = String.join("%20","https://www.google.com/travel/flights?q=Flights","to",toAirport,"from",fromAirport,
                "oneway","on",fullDateStart,"through",fullDateEnd,"with",countAdults,"adult");
        chromeDriver.get(roundTripURL);
    }





}
