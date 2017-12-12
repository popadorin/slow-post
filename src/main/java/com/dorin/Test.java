//package com.dorin;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.InetAddress;
//import java.net.Socket;
//
//enum Method {
//    GET,
//    POST,
//}
//
//public class Test {
//    public static void main(String[] args) {
//
//        Method method = Method.GET;
//
//        switch (method) {
//            case GET:
//                while(!StopWorking)
//                {
//                    for(int i=0;i<per_Thread;i++)
//                    {
//                        if(socks[i].isConnected())
//                        {
//                            try
//                            {
//                                PrintWriter pw = new PrintWriter(socks[i].getOutputStream());
//                                pw.println("GET / HTTP/1.1");
//                                pw.println("Host: " + hp.getHostText());
//                                pw.println();
//                                pw.flush();
//                            }
//                            catch (Exception e){}
//                        }
//                        else
//                        {
//                            try {
//                                socks[i] = new Socket(InetAddress.getByName(hp.getHostText()), hp.getPort());
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }
//                break;
//            case POST:
//                for(int i=0;i<per_Thread;i++) {
//                    try {
//                        socks[i].close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                while(!StopWorking) {
//                    for(int i=0;i<per_Thread;i++)
//                    {
//                        if(socks[i].isConnected())
//                        {
//                            try {
//                                PrintWriter pw = new PrintWriter(socks[i].getOutputStream());
//                                pw.println();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        else
//                        {
//                            try {
//                                socks[i] = new Socket(InetAddress.getByName(hp.getHostText()), hp.getPort());
//                                PrintWriter pw = new PrintWriter(socks[i].getOutputStream());
//                                pw.println("POST / HTTP/1.1");
//                                pw.println("User-Agent: %s");
//                                pw.println("Connection: keep-alive");
//                                pw.println("Keep-Alive: 900");
//                                pw.println("Content-Length: 10000");
//                                pw.println("Content-Type: application/x-www-form-urlencoded");
//                                pw.println();
//                                pw.flush();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }
//                break;
//        }
//    }
//}
