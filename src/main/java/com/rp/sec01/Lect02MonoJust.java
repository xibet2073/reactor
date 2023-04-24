package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lect02MonoJust {

    public static void main(String[] args) {
        //Publisher
        Mono<Integer> mono= Mono.just(1);

        System.out.println(mono);

        mono.subscribe(i -> System.out.println("Received: " + i));
    }
}
