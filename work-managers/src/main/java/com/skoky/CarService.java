package com.skoky;

import com.skoky.data.Car;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
public class CarService {

    @GET
    @Path("{made}")
    public Car getCarByMade(@PathParam("made") String made) throws InterruptedException {
        Car c = new Car(made,"BMW");
         Thread.sleep(50);
        return c;
    }

}
