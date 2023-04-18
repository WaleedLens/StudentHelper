package model;

import java.time.LocalDateTime;

public class Flight implements Comparable {

    private String flightCode;
    private String company;
    private long price;
    private String timeInterval;


    public Flight(String flightCode, String company, long price, String timeInterval) {
        this.flightCode = flightCode;
        this.company = company;
        this.price = price;
        this.timeInterval = timeInterval;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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

        return 0;
    }
}
