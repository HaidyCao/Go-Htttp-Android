package go.http.java;

import http.GoClient;
import http.GoResponse;
import http.Http;

public class GoHttpClient {

    public GoResponse request(GoClient client) throws Exception {
        return Http.request(client);
    }
}
