package example;


import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.ArrayList;
import java.util.List;

@Path("/json/metallica")
public class JSONService {

    @Resource    // Step 1
    private WebServiceContext wsContext;    // Step 2

    @Context
    private ServletContext sc;

    List<Track> trackList = new ArrayList<Track>();
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {

        Track track = new Track();
        track.setTitle("Enter Sandman Jay");
        track.setSinger("Metallica");
        //track.setSong(new byte[1024*1024]);

        trackList = (List<Track>) sc.getAttribute("tracks");
        if (trackList==null) trackList = new ArrayList<Track>();
        trackList.add(track);
        System.out.println("Tracks big:"+trackList.size());
        sc.setAttribute("tracks",trackList);
        return track;

    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track) {

        String result = "Track saved : " + track;
        return Response.status(201).entity(result).build();

    }
}