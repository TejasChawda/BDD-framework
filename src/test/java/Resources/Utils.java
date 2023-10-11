package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification req;
    public RequestSpecification getRequestSpecifications() throws IOException {
        if(req == null){
            PrintStream print = new PrintStream(new FileOutputStream("logs.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key","qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(print))
                    .addFilter(ResponseLoggingFilter.logResponseTo(print))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("src/test/java/Resources/features.properties");
        props.load(file);
        return props.getProperty(key);
    }

    public String getJsonPath(Response res, String key){
        String resp = res.asString();
        JsonPath jsonPath = new JsonPath(resp);
        return jsonPath.get(key).toString();
    }
}
