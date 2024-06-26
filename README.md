# URL Shortener

Your challenge will be to implement a service that allows you to shorten long URLs to make them more compact and easier to read.
to share.

## Example

Your service receives a call to shorten a URL. For example, when you receive the URL `https://google.com.br`, you must return a shortened URL, such as `https://xxx.com/DXB6V`.

When a user accesses the shortened URL `https://xxx.com/DXB6V`, your service must redirect the user to the original URL `https://google.com.br`.

**[POST]** `{{host}}/shorten-url`

```json
{
    "url": "https://google.com.br"
}
```

return:

```
HTTP/1.1 200 OK
```

```json
{
    "url": "https://xxx.com/DXB6V"
}
```

## Requirements

- The URL shortener takes a long URL as an initial parameter.
- The shortening will consist of a minimum of 05 and a maximum of 10 characters.
- Only letters and numbers are allowed in shortening.
- The shortened URL will be saved in the database with an expiration date (you can choose the desired duration).
- When receiving a call to the shortened URL `https://xxx.com/DXB6V`, you must redirect to the
  Original URL saved in the database. If the URL is not found in the database, return the code
  status `HTTP 404 (Not Found)`.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-urlshortener-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- MongoDB client ([guide](https://quarkus.io/guides/mongodb)): Connect to MongoDB in either imperative or reactive style
- REST JSON-B ([guide](https://quarkus.io/guides/rest#json-serialisation)): JSON-B serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- MongoDB with Panache ([guide](https://quarkus.io/guides/mongodb-panache)): Simplify your persistence code for MongoDB via the active record or the repository pattern
- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, Jakarta Persistence)
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
