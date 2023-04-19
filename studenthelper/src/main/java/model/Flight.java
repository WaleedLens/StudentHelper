package model;

import java.time.LocalDateTime;

public class Flight implements Comparable {

    private String stopsIfAny;
    private String company;
    private int price;
    private String timeInterval;


    public Flight(String stopsIfAny, String company, int price, String timeInterval) {
        this.stopsIfAny = stopsIfAny;
        this.company = company;
        this.price = price;
        this.timeInterval = timeInterval;
    }

    public String getFlightCode() {
        return stopsIfAny;
    }

    public void setFlightCode(String flightCode) {
        this.stopsIfAny = flightCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }


    @Override
    public int compareTo(Object o) {
        Flight a = (Flight) o;
        if(a.price > this.price)
            return -1;
        else
            return 0;
    }
}
