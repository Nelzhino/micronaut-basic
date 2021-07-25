package com.hkg.micronaut.airport.controller;

import com.hkg.micronaut.airport.entity.Airport;
import com.hkg.micronaut.airport.service.AirportService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/airport")
public class AirportController {

    /**
     *
     */
    @Inject
    public AirportService airportService;

    /**
     *
     * @return
     */
    @Get("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Airport> getAll() {
        return  airportService.getAllAirports();
    }


    @Get(value = "/heaven", produces = MediaType.TEXT_PLAIN)
    String getTest() {
        return "some string";
    }

    /**
     *
     * @param airportCode
     * @return
     */
    @Get("/find/{airportCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Airport getAirportByCode(String airportCode) {
        return airportService.getAirportByCode(airportCode);
    }

    /**
     *
     * @param airport
     * @return
     */
    @Post("/saveAirport")
    @Produces(MediaType.APPLICATION_JSON)
    public Airport saveOrUpdate(@Body Airport airport) {
        return airportService.saveOrupdateAirport(airport);

    }

    /**
     *
     * @param airportId
     * @return
     */
    @SuppressWarnings("rawtypes")
	@Delete("delete/{airportId}")
    public HttpResponse delete(Long airportId) {
        airportService.deleteAirport(airportId);
        return HttpResponse.ok();
    }

}
