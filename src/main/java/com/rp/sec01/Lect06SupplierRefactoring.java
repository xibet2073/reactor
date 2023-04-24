package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lect06SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        /*getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(
                        Util.onNext()
                );*/
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block(); // blocks the main thread and wait the execution
        System.out.println("Name: " + name);
        getName();

        Util.sleepSeconds(4); // blocks the main thread
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName method");
        return Mono.fromSupplier( () -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
