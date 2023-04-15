package model;

import java.time.LocalDateTime;

public class Flight {

    private String flightCode;
    private String company;
    private long price;
    private LocalDateTime time;


    public Flight(String flightCode, String company, long price, LocalDateTime time) {
        this.flightCode = flightCode;
        this.company = company;
        this.price = price;
        this.time = time;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
