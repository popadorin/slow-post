package com.dorin.slowpost;

import java.io.IOException;

import static com.dorin.slowpost.Configurations.NR_OF_THREADS;

public class Main {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < NR_OF_THREADS; i++) {
                new Thread(() -> {
                    try {
                        new TcpPostConnection().run();
                    } catch (IOException e) {
                        System.out.println("error: " + e.getMessage());
                    }
                }).start();
            }

            System.out.println("JORA");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }

}
