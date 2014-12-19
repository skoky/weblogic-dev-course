package com.skoky;

import com.skoky.data.Car;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
public class CarService {

    @GET
    @Path("{made}")
    public Car getCarByMade(@PathParam("made") String made) {
        Car c = new Car(made,"BMW");
        return c;
    }

}
