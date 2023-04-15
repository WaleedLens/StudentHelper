import core.Webserver;
import requests.DemoRequest;
import requests.HttpRequest;

public class Main {


    public static void main(String[] args){
        Webserver wb = new Webserver();
        wb.route(DemoRequest.class,"DemoRequest","/demo");
        wb.route(HttpRequest.class,"HttpRequest","/req");

        wb.startServer();
    }
}
