package core;

import core.utils.PatternUtils;
import model.Flight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class FlightSearch {

    private final ChromeDriver chromeDriver;

    Logger log = Logger.getLogger(FlightSearch.class.getName());


    public FlightSearch(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        log.info("Flight search has been initiated");
    }

    //https://www.google.com/travel/flights?q=Flights%20to%20#AIRPORT_CODE#%20from%20#AIRPORT_CODE#%20on%20#YEAR#-#MONTH#-#DAY#%20through%20#YEAR#-#MONTH#-#DAY#
    //https://www.google.com/travel/flights?q=Flights%20to%20#AIRPORT_CODE#%20from%20#AIRPORT_CODE#%20on%20#YEAR#-#MONTH#-#DAY#%20through%20#YEAR#-#MONTH#-#DAY#

    /**
     * This method returns cheapest flight from google flights.
     * @return
     */
    public Flight getCheapestFlight() {

        log.info("Flights information are being extracted... please hold on!");

        List<String> timeIntervals = getTimeIntervals();
        List<Integer> prices = getPrices();
        List<String> stopsIfAny = getStopsIfAny();
        List<String> flightsCarrier = getFlightsCarrier();


        int[] tempArr = {timeIntervals.size(), prices.size(), stopsIfAny.size(), flightsCarrier.size()};
        int k = 0;
        for (int i : tempArr) {
            if (k == 0) {
                k = i;
            }
            if (i < k) {
                k = i;
            }
        }
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            flights.add(new Flight(stopsIfAny.get(i), flightsCarrier.get(i), prices.get(i), timeIntervals.get(i)));

        }

        log.info("Flights fetched: " + flights.size());
        Flight cheapestFlight = Collections.min(flights);

        return cheapestFlight;
    }

    private List<String> getStopsIfAny() {
        List<String> stopsList = new ArrayList<>();
        List<WebElement> wb1 = chromeDriver.findElements(By.className("rGRiKd"));
        for (WebElement e : wb1) {
            String flightCarrier = e.getAttribute("outerHTML").replaceAll("<span>", "").replaceAll("</span>", "").replaceAll("<span class=\"h1fkLb\">", "");
            stopsList.add(flightCarrier);
        }

        log.info("Stops fetched.\nSize:" + stopsList.size());
        return stopsList;
    }

    private List<Integer> getPrices() {
        List<Integer> prices = new ArrayList<>();
        List<WebElement> wb = chromeDriver.findElements(By.ByClassName.className("BVAVmf"));
        for (WebElement e : wb) {
            if (e.getText().contains("SAR")) {
                prices.add(PatternUtils.getPriceAsInteger(e.getText()));
            }
        }
        if (prices.size() == 0)
            throw new IllegalStateException("Unable to fetch data");
        log.info("Prices of flights are fetched. \nSize:" + prices.size());
        return prices;
    }

    private List<String> getFlightsCarrier() {
        List<String> flightsCarrier = new ArrayList<>();
        List<WebElement> wb2 = chromeDriver.findElements(By.className("h1fkLb"));
        for (WebElement e : wb2) {
            flightsCarrier.add(e.getText());
        }

        return flightsCarrier;
    }

    private List<String> getTimeIntervals() {
        List<WebElement> wb = chromeDriver.findElements(By.className("YMlIz"));
        List<String> timeIntervals = new ArrayList<>();
        for (WebElement e : wb) {
            String timeInterval = e.getText().replaceAll("\\s", "").replaceAll("-", "").replaceAll("\\s", "");
            if (timeInterval.matches("^[0-9]+:[0-9]+.(PM|AM|am|pm).[0-9]+:[0-9]+.(PM|AM|am|pm)$")) {
                timeIntervals.add(e.getText().replaceAll("\n", ""));
            }

        }
        if (timeIntervals.size() == 0)
            throw new IllegalStateException("Unable to fetch data");
        log.info("Time intervals extracted from flights.\nSize:" + timeIntervals.size());
        return timeIntervals;
    }


    public void googleFlightOneWay(String fromAirport, String toAirport, int year, int month, int day, int adults) {
        String fullDateInString = String.join("-", String.valueOf(year), String.valueOf(month), String.valueOf(day));
        String countAdults = PatternUtils.getAdultsNumber(adults);
        String oneWayURL = String.join("%20", "https://www.google.com/travel/flights?q=Flights", "to", toAirport, "from", fromAirport,
                "oneway", fullDateInString, "with", countAdults, "adult");
        chromeDriver.get(oneWayURL);
    }


    public void googleFlightRoundTrip(String fromAirport, String toAirport, int yearStart, int monthStart, int dayStart,
                                      int adults, int yearEnd, int monthEnd, int dayEnd) {

        String fullDateStart = String.join("-", String.valueOf(yearStart), String.valueOf(monthStart), String.valueOf(dayStart));
        String fullDateEnd = String.join("-", String.valueOf(yearEnd), String.valueOf(monthEnd), String.valueOf(dayEnd));

        String countAdults = PatternUtils.getAdultsNumber(adults);
        String roundTripURL = String.join("%20", "https://www.google.com/travel/flights?q=Flights", "to", toAirport, "from", fromAirport,
                "oneway", "on", fullDateStart, "through", fullDateEnd, "with", countAdults, "adult");
        chromeDriver.get(roundTripURL);
    }


}
