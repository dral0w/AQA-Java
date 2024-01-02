import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class Lesson16Tests {

    @Test
    public void getMethodTest() {
        RestAssured.baseURI = "https://postman-echo.com";
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("/get");

        assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertEquals("bar1", response.jsonPath().getString("args.foo1")),
                () -> assertEquals("bar2", response.jsonPath().getString("args.foo2")),
                () -> assertEquals("https", response.jsonPath().getString("headers.x-forwarded-proto")),
                () -> assertEquals("443", response.jsonPath().getString("headers.x-forwarded-port")),
                () -> assertEquals("postman-echo.com", response.jsonPath().getString("headers.host")),
                () -> assertEquals("Apache-HttpClient/4.5.13 (Java/17)", response.jsonPath().getString("headers.user-agent")),
                () -> assertEquals("*/*", response.jsonPath().getString("headers.accept")),
                () -> assertEquals("gzip,deflate", response.jsonPath().getString("headers.accept-encoding")),
                () -> assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", response.jsonPath().getString("url"))
        );
    }

    @Test
    public void postMethodTest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "{\"key\":\"value\"}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/post");

        assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertEquals("[:]", response.jsonPath().getString("args")),
                () -> assertEquals("[key:value]", response.jsonPath().getString("data")),
                () -> assertEquals("[:]", response.jsonPath().getString("files")),
                () -> assertEquals("[:]", response.jsonPath().getString("form")),
                () -> assertEquals("https", response.jsonPath().getString("headers.x-forwarded-proto")),
                () -> assertEquals("443", response.jsonPath().getString("headers.x-forwarded-port")),
                () -> assertEquals("postman-echo.com", response.jsonPath().getString("headers.host")),
                () -> assertEquals("15", response.jsonPath().getString("headers.content-length")),
                () -> assertEquals("Apache-HttpClient/4.5.13 (Java/17)", response.jsonPath().getString("headers.user-agent")),
                () -> assertEquals("*/*", response.jsonPath().getString("headers.accept")),
                () -> assertEquals("application/json", response.jsonPath().getString("headers.content-type")),
                () -> assertEquals("gzip,deflate", response.jsonPath().getString("headers.accept-encoding")),
                () -> assertEquals("value", response.jsonPath().getString("json.key")),
                () -> assertEquals("https://postman-echo.com/post", response.jsonPath().getString("url"))
        );
    }

    @Test
    public void putMethodTest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "{\"key\":\"value\"}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("/put");

        assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertEquals("[:]", response.jsonPath().getString("args")),
                () -> assertEquals("[key:value]", response.jsonPath().getString("data")),
                () -> assertEquals("[:]", response.jsonPath().getString("files")),
                () -> assertEquals("[:]", response.jsonPath().getString("form")),
                () -> assertEquals("https", response.jsonPath().getString("headers.x-forwarded-proto")),
                () -> assertEquals("443", response.jsonPath().getString("headers.x-forwarded-port")),
                () -> assertEquals("postman-echo.com", response.jsonPath().getString("headers.host")),
                () -> assertEquals("15", response.jsonPath().getString("headers.content-length")),
                () -> assertEquals("Apache-HttpClient/4.5.13 (Java/17)", response.jsonPath().getString("headers.user-agent")),
                () -> assertEquals("*/*", response.jsonPath().getString("headers.accept")),
                () -> assertEquals("application/json", response.jsonPath().getString("headers.content-type")),
                () -> assertEquals("gzip,deflate", response.jsonPath().getString("headers.accept-encoding")),
                () -> assertEquals("value", response.jsonPath().getString("json.key")),
                () -> assertEquals("https://postman-echo.com/put", response.jsonPath().getString("url"))
        );
    }

    @Test
    public void patchMethodTest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "{\"key\":\"value\"}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .patch("/patch");

        assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertEquals("[:]", response.jsonPath().getString("args")),
                () -> assertEquals("[key:value]", response.jsonPath().getString("data")),
                () -> assertEquals("[:]", response.jsonPath().getString("files")),
                () -> assertEquals("[:]", response.jsonPath().getString("form")),
                () -> assertEquals("https", response.jsonPath().getString("headers.x-forwarded-proto")),
                () -> assertEquals("443", response.jsonPath().getString("headers.x-forwarded-port")),
                () -> assertEquals("postman-echo.com", response.jsonPath().getString("headers.host")),
                () -> assertEquals("15", response.jsonPath().getString("headers.content-length")),
                () -> assertEquals("Apache-HttpClient/4.5.13 (Java/17)", response.jsonPath().getString("headers.user-agent")),
                () -> assertEquals("*/*", response.jsonPath().getString("headers.accept")),
                () -> assertEquals("application/json", response.jsonPath().getString("headers.content-type")),
                () -> assertEquals("gzip,deflate", response.jsonPath().getString("headers.accept-encoding")),
                () -> assertEquals("value", response.jsonPath().getString("json.key")),
                () -> assertEquals("https://postman-echo.com/patch", response.jsonPath().getString("url"))
        );
    }

    @Test
    public void deleteMethodTest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given().delete("/delete");

        assertEquals(200, response.getStatusCode());

        assertAll(
                () -> assertEquals(200, response.statusCode()),
                () -> assertEquals("[:]", response.jsonPath().getString("args")),
                () -> assertEquals("[:]", response.jsonPath().getString("data")),
                () -> assertEquals("[:]", response.jsonPath().getString("files")),
                () -> assertEquals("[:]", response.jsonPath().getString("form")),
                () -> assertEquals("https", response.jsonPath().getString("headers.x-forwarded-proto")),
                () -> assertEquals("443", response.jsonPath().getString("headers.x-forwarded-port")),
                () -> assertEquals("postman-echo.com", response.jsonPath().getString("headers.host")),
                () -> assertEquals("Apache-HttpClient/4.5.13 (Java/17)", response.jsonPath().getString("headers.user-agent")),
                () -> assertEquals("*/*", response.jsonPath().getString("headers.accept")),
                () -> assertEquals("application/json", response.jsonPath().getString("headers.content-type")),
                () -> assertEquals("gzip,deflate", response.jsonPath().getString("headers.accept-encoding")),
                () -> assertNull(response.jsonPath().getString("json")),
                () -> assertEquals("https://postman-echo.com/delete", response.jsonPath().getString("url"))
        );

    }
}
