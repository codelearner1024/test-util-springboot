package com.wwg.threads;

public class VolatileTest {
    static class A {
        int a = 0;
        volatile boolean flag = false;

        void writer() {
            a = 1;                   //1
            flag = true;               //2
            System.out.println("write");
        }

        void reader() {
            if (flag) {                //3
                int i =  a;           //4
                System.out.println("read true");
                System.out.println("i is :" + i);
            } else {
                int i = a;
                System.out.println("read false");
                System.out.println("i is :" + i);
            }
        }

    }

    public static void main(String[] args) {
        A aaa = new A();
        new Thread(aaa::reader).start();
        new Thread(aaa::writer).start();
//        new Thread(() -> new A().writer()).start();
//        new Thread(() -> new A().reader()).start();
    }
}

