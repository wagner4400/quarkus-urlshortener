package wsr.codetest.com.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.bson.Document;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class MongoDbConfig {
    @ConfigProperty(name = "quarkus.mongodb.database")
    String DATABASE;
    @ConfigProperty(name = "url.expires.after.seconds")
    Long EXPIRES_AFTER_SECONDS;
    
    @Inject
    MongoClient mongoClient;
    
    public void onStart(@Observes StartupEvent ev) {
        MongoCollection<Document> collection = mongoClient.getDatabase(DATABASE).getCollection(DATABASE);
        IndexOptions indexOptions = new IndexOptions().expireAfter(EXPIRES_AFTER_SECONDS, TimeUnit.SECONDS);
        collection.createIndex(Indexes.ascending("expires_at"), indexOptions);
    }
}
