package com.skoky;

import com.skoky.db.Car;
import com.skoky.db.DBHelper;
import com.skoky.db.DBHelperPS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Path("/carstore")
@Produces(MediaType.APPLICATION_JSON)
public class CarService {

    @GET
    @Path("{made}")
    public HashMap<String, String> getCarStore(@PathParam("made") String made) {
        Car c = new Car(made,"Mazda");
        List<String> owners = new DBHelper().getOwners();
        // List<String> owners = new DBHelperPS().getOwners();
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("car",c.getMade());
        if (owners!=null)
            result.put("owners", Arrays.toString(owners.toArray()));
        else
            result.put("owners", "[]");
        return result;
    }

}
