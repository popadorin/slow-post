package com.dorin;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpSlowPost {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        try {
            Socket s = new Socket(InetAddress.getByName("192.168.1.3"), 3000);
            PrintWriter pw = new PrintWriter(s.getOutputStream());

            pw.println("POST /users HTTP/1.1");
            pw.println("Host: 192.168.1.3:3000");
            pw.println("Content-Type:application/json");
            pw.println("Cache-Control: no-cache");
            pw.println("");
            String postObject = gson.toJson(new User("Messi", 40));
            System.out.println("Post obj: " + postObject);
            pw.println(postObject);
            pw.println("");
            pw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String t;
            while ((t = br.readLine()) != null) System.out.println(t);
            br.close();

        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println();
        }
    }
}