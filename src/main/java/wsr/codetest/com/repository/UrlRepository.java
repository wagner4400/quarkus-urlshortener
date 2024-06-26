package wsr.codetest.com.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import wsr.codetest.com.model.Url;

@ApplicationScoped
public class UrlRepository implements PanacheMongoRepository<Url> {
}
