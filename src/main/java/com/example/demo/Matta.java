package com.example.demo;

public class Matta {
    public static void main(String[] args) {
            SampleThread sampleThread = new SampleThread();
            sampleThread.start();
    }
}

 class SampleThread extends Thread {

     @Override
     public void run() {
         System.out.println("kk");
     }
 }
