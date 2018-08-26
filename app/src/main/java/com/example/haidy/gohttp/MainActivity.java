package com.example.haidy.gohttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import http.GoClient;
import http.GoHttpTransport;
import http.GoResponse;
import http.GoTcpDial;
import http.GoTcpDialCreater;
import http.Http;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GoClient client = new GoClient();
                    client.setUrl("https://www.baidu.com");
                    client.setMethod("GET");

                    GoHttpTransport transport = new GoHttpTransport();
                    transport.setTlsCreater(new GoTcpDialCreater() {
                        @Override
                        public GoTcpDial createGoDial(String s) throws Exception {
                            GoTcpDial tcpDial = Http.getGoTcpDial(s);
                            return Http.updateDialToSSLTcpDial(tcpDial);
                        }
                    });
                    client.setTransport(transport);

                    GoResponse response = Http.request(client);
                    System.out.println(response.getStatueCode());
                    System.out.println(response.getBody().string());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
