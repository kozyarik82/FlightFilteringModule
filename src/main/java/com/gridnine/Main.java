package com.gridnine;

import com.gridnine.testing.filter.FlightFilterImpl;
import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> allFlights = FlightBuilder.createFlights();
        FlightFilterImpl flightFilter = new FlightFilterImpl();
        List<Flight> filterFlight = flightFilter.departureUntilNow(allFlights);
        System.out.println(filterFlight);
        filterFlight = flightFilter.arrivalBeforeDeparture(allFlights);
        System.out.println(filterFlight);
        filterFlight = flightFilter.timeOnTheGroundMore2Hours(allFlights);
        System.out.println(filterFlight);
    }
}