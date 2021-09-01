package com.aoki.test;

import java.io.IOException;
import java.net.Socket;

public class JavaClientTest {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("127.0.0.1",7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
