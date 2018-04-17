package api.tests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class PHEndpoint {
        private int code;
        private String body;

        @BeforeAll
        void setUp() throws IOException {
            HttpUriRequest request = new HttpGet("http://p3tew145y3tag41n:0hy34hh@api.local/campaign/300659/reward");
            HttpResponse response = HttpClientBuilder.create().build().execute(request);
            HttpEntity entity = response.getEntity();
            code = response.getStatusLine().getStatusCode();
            body = EntityUtils.toString(entity);
        }

        @Test
        @DisplayName("Response code is correct")
        void responseCode(){
            assertEquals(201,code);
        }

        @Test
        @DisplayName("Response body is correct")
        void responseBody(){
            assertEquals("", body);
        }
    }
}
