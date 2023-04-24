package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lect08MonoFromRunnable {
    public static void main(String[] args) {
        //Runnable runnable = () -> System.out.println("");
        System.out.println("Main thread: " + Thread.currentThread().getName());
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process id done. Sending emails...");
                        });
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            System.out.println("Runnable thread: " + Thread.currentThread().getName());
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
