package wsr.codetest.com.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import wsr.codetest.com.model.dto.ShortenUrlResponse;
import wsr.codetest.com.model.entity.Url;
import wsr.codetest.com.repository.UrlRepository;

import java.net.URI;
import java.time.LocalDateTime;

@ApplicationScoped
public class UrlService {
    @Inject
    UrlRepository urlRepository;
    @ConfigProperty(name = "url.expires.after.seconds")
    Long EXPIRES_AFTER_SECONDS;
    
    public ShortenUrlResponse shortenUrl(String baseUrl, String originalUrl) {
        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (!urlRepository.findByIdOptional(id).isEmpty());
        
        var urlEntity = new Url(id, originalUrl, LocalDateTime.now().plusSeconds(EXPIRES_AFTER_SECONDS));
        urlRepository.persist(urlEntity);
        
        var redirectUrl = baseUrl.replace("shorten-url", id);
        
        return new ShortenUrlResponse(redirectUrl);
    }
    
    public Response redirect(String id) {
        var urlEntity = urlRepository.findByIdOptional(id);
        
        if (urlEntity.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.seeOther(URI.create(urlEntity.get().getFullUrl())).build();
    }
}
