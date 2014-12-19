package com.skoky;

import com.skoky.data.Car;
import com.skoky.data.CarStore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Path("/carstore")
@Produces(MediaType.APPLICATION_JSON)
public class CarService {

    @GET
    @Path("{made}")
    public HashMap<String, String> getCarStore(@PathParam("made") String made) {
        Car c = new Car(made,"Mazda");
        CarStore.stock.add(c);
        HashMap<String, String> store = new HashMap<String, String>();
        store.put("made",c.getMade());
        store.put("stock",Integer.toString(CarStore.stock.size()));
        return store;
    }

}
