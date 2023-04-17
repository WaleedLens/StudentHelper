package core;

import core.utils.PatternUtils;
import model.Flight;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.util.List;

public class FlightSearch {

    private final ChromeDriver chromeDriver;

    public FlightSearch(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;

    }

    //https://www.google.com/travel/flights?q=Flights%20to%20#AIRPORT_CODE#%20from%20#AIRPORT_CODE#%20on%20#YEAR#-#MONTH#-#DAY#%20through%20#YEAR#-#MONTH#-#DAY#
    //https://www.google.com/travel/flights?q=Flights%20to%20#AIRPORT_CODE#%20from%20#AIRPORT_CODE#%20on%20#YEAR#-#MONTH#-#DAY#%20through%20#YEAR#-#MONTH#-#DAY#
    public List<Flight> getFlights(String toCity, String fromCity, LocalDateTime fromDate, LocalDateTime toDate){

        return null;
    }


    public void GoogleFlightOneWay(String fromAirport,String toAirport,int year,int month,int day,int adults){
        String fullDateInString =  String.join("-",String.valueOf(year),String.valueOf(month),String.valueOf(day));
        String countAdults = PatternUtils.getAdultsNumber(adults);
        String oneWayURL = String.join("%20","https://www.google.com/travel/flights?q=Flights","to",toAirport,"from",fromAirport,
                "oneway",fullDateInString,"with",countAdults,"adult");
        chromeDriver.get(oneWayURL);
    }





    public void InitGoogleFlightRoundTrip(String fromAirport,String toAirport,int yearStart,int monthStart,int dayStart,
          int adults,int yearEnd,int monthEnd,int dayEnd){

        String fullDateStart =  String.join("-",String.valueOf(yearStart),String.valueOf(monthStart),String.valueOf(dayStart));
        String fullDateEnd =  String.join("-",String.valueOf(yearEnd),String.valueOf(monthEnd),String.valueOf(dayEnd));

        String countAdults = PatternUtils.getAdultsNumber(adults);
        String roundTripURL = String.join("%20","https://www.google.com/travel/flights?q=Flights","to",toAirport,"from",fromAirport,
                "oneway","on",fullDateStart,"through",fullDateEnd,"with",countAdults,"adult");
        chromeDriver.get(roundTripURL);
    }




}
