package com.example.haidy.gohttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import go.http.java.GoHttpClient;
import http.GoClient;
import http.GoResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                GoHttpClient httpClient = new GoHttpClient();
                try {
                    GoClient client = new GoClient();
                    client.setUrl("http://www.baidu.com");
                    client.setMethod("GET");
                    GoResponse response = httpClient.request(client);
                    System.out.println(response.getStatueCode());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
