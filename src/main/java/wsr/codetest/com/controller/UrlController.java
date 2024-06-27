package wsr.codetest.com.controller;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import wsr.codetest.com.model.dto.ShortenUrlRequest;
import wsr.codetest.com.service.UrlService;

@Path("/urls")
public class UrlController {
    
    @Inject
    UrlService urlService;
    @Context
    UriInfo uriInfo;
    
    @POST
    @Path("/shorten-url")
    public Response shortenUrl(ShortenUrlRequest request) {
        var baseUrl = uriInfo.getAbsolutePath().toString();
        return Response.ok(urlService.shortenUrl(baseUrl, request.url())).build();
    }
    
    @GET
    @Path("{id}")
    public Response redirect(@NotNull @PathParam("id") String id) {
        return urlService.redirect(id);
    }
}
