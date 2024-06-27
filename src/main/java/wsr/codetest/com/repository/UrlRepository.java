package wsr.codetest.com.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import wsr.codetest.com.model.entity.UrlEntity;

@ApplicationScoped
public class UrlRepository implements PanacheMongoRepositoryBase<UrlEntity, String> {
}
