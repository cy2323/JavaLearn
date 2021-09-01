package com.aoki.test;

public class JavaTest7 {

    public static boolean ready;
    public static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println("1.  " + number);
                Thread.yield();
            }
            System.out.println("2.  " + number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();

        Thread.sleep(1000);

        number = 42;
        ready = true;
    }
}


