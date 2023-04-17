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

        wb.route(HttpRequest.class,"HttpRequest","/req");
        wb.startServer();
    }
}
