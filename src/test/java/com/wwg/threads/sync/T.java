package com.wwg.threads.sync;

public class T {

    public static volatile int i = 0;

    public static void main(String[] args) {
      for(int i=0; i<1000000; i++) {
         m();
         n();
      }
    }
    
    public static synchronized void m() {
      
    }

    public static void n() {
      i = 1;
    }
  }

