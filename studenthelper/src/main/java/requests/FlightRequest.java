package requests;

import jakarta.servlet.http.HttpServlet;
import model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public class FlightRequest extends HttpServlet {


    /**
     * Returns all flight in given date[FROM <-> TO]
     * @param from
     * @param to
     * @param destination name of destination (e.g., city you want travel to)
     * @return
     */
    public List<Flight> getFlights(LocalDateTime from,LocalDateTime to,String destination){
        //TODO:get all flights to given destination in a given date interval.
        return null;
    }




}
