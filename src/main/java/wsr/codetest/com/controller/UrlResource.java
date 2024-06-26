package wsr.codetest.com.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import wsr.codetest.com.service.UrlService;

@Path("/urls")
public class UrlResource {
    
    @Inject
    UrlService urlService;
    
    @POST
    @Path("/shorten-url")
    public Response hello() {
        //TODO: Implement this method
        return Response.ok("Hello from Quarkus REST").build();
    }
}
