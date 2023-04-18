import com.google.inject.Injector;
import core.FlightSearch;
import core.SeleniumScrape;
import core.Webserver;
import core.utils.FileUtils;
import requests.HttpRequest;

import javax.inject.Inject;

public class Main {


    public static void main(String[] args){
        SeleniumScrape seleniumScrape = new SeleniumScrape();
        Webserver wb = new Webserver();
        FlightSearch f = new FlightSearch(seleniumScrape.getChromeDriver());
        f.googleFlightOneWay("JED", "DMM", 2023, 5, 3, 2);
        f.getFlights();
        
        wb.route(HttpRequest.class,"HttpRequest","/req");
        wb.startServer();
    }
}
