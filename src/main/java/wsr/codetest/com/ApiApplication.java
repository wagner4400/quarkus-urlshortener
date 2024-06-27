package wsr.codetest.com;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

/*
This class is not required for Quarkus but because we're using the OpenAPI annotations,
we need to define the application class.
 */
@OpenAPIDefinition(
        info = @Info(
                title="Url Shortener API",
                version = "1.0.1",
                contact = @Contact(
                        name = "Wagner Souza Ramalho",
                        url = "https://www.linkedin.com/in/wagnerramalho/",
                        email = "wagner4400@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class ApiApplication extends Application {
}
