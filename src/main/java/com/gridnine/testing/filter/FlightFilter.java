package com.gridnine.testing.filter;

import com.gridnine.testing.testClasses.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> departureUntilNow(List<Flight> flights);

    List<Flight> arrivalBeforeDeparture(List<Flight> flights);

    List<Flight> timeOnTheGroundMore2Hours(List<Flight> flights);
}
