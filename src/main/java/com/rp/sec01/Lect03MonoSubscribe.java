package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lect03MonoSubscribe {
    public static void main(String[] args) {
        //Publisher
        final Mono<Integer> mono = Mono.just("ball")
                .map(String::length);
                //.map(l -> l / 0);

        // 1
        //mono.subscribe();

        // 2
        /*mono.subscribe(
                item -> System.out.println(item), //consumer for onNext
                err -> System.out.println(err.getMessage()), // consumer for onError
                () -> System.out.println("Completed") // consumer for onComplete
        );*/

        // 3
        mono.subscribe(
                Util.onNext(), //consumer for onNext
                Util.onError(), // consumer for onError
                Util.onComplete() // consumer for onComplete
        );

    }
}
