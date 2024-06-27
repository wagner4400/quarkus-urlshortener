package wsr.codetest.com.model.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDateTime;

@MongoEntity(database = "urls")
public class Url {
    @BsonId
    private String id;
    @BsonProperty(value = "full_url")
    private String fullUrl;
    @BsonProperty(value = "expires_at")
    private LocalDateTime expiresAt;
    
    public Url() {
    }
    
    public Url(String id, String fullUrl, LocalDateTime expiresAt) {
        this.id = id;
        this.fullUrl = fullUrl;
        this.expiresAt = expiresAt;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getFullUrl() {
        return fullUrl;
    }
    
    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }
    
    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
    
    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
