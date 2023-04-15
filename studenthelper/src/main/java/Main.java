import core.Webserver;
import requests.HttpRequest;

public class Main {


    public static void main(String[] args){
        Webserver wb = new Webserver();
        wb.route(HttpRequest.class,"HttpRequest","/req");

        wb.startServer();
    }
}
