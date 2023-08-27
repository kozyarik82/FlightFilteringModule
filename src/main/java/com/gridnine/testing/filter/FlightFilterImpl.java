package com.gridnine.testing.filter;

import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterImpl implements FlightFilter{
    @Override
    public List<Flight> departureUntilNow(List<Flight> flights) {
        System.out.println(" Flights that have departure is before the current time: ");
        List<Flight> filteredFlightList = new ArrayList<>(flights);
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                    filteredFlightList.remove(flight);
                }
            }
        }

        return filteredFlightList;
    }

    @Override
    public List<Flight> arrivalBeforeDeparture(List<Flight> flights) {
        System.out.println(" Flights that have segments departing before arrival: ");
        List<Flight> filteredFlightList = new ArrayList<>(flights);
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    filteredFlightList.remove(flight);
                }
            }
        }
        return filteredFlightList;
    }

    @Override
    public List<Flight> timeOnTheGroundMore2Hours(List<Flight> flights) {
        System.out.println(" Flights with time spent on the ground exceeding two hours: ");
        List<Flight> filteredFlightList = new ArrayList<>(flights);
        long timeOnTheGround = 0;
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
                if (segments.size() > 1) {
                    for (int i = 0; i < segments.size() - 1; i++) {
                        LocalDateTime arrivalDate = segments.get(i).getArrivalDate();
                        LocalDateTime departureDate = segments.get(i + 1).getDepartureDate();
                        timeOnTheGround = Duration.between(arrivalDate, departureDate).toHours();
                    }
                }
                if (timeOnTheGround > 2) {
                    filteredFlightList.remove(flight);
                }
                timeOnTheGround = 0;
            }
        return filteredFlightList;
    }
}
