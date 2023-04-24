package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class Lect05MonoFromSupplier {
    public static void main(String[] args) {
        // Use just only when you have data already
        // Mono<String> mono = Mono.just(getName());

        // Supplier is a functional interface. Does not receive anything but
        // returns an object.
        // Use fromSupplier when a Mono with an item is created from a function.
        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(
                Util.onNext()
        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }
}
