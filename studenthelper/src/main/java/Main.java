import service.FlightSearchService;
import service.SeleniumService;
import core.Webserver;
import requests.HttpRequest;

public class Main {


    public static void main(String[] args){
        SeleniumService seleniumScrape = new SeleniumService();
        Webserver wb = new Webserver();
        FlightSearchService f = new FlightSearchService(seleniumScrape.getChromeDriver());
        f.googleFlightOneWay("JED", "DMM", 2023, 5, 3, 1);
        f.getCheapestFlight();
        
        wb.route(HttpRequest.class,"HttpRequest","/req");
        wb.startServer();
    }
}
