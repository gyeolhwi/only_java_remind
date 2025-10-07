package com.study.상속_다형성;

public class Car extends Vehicle {
    @Override
    public void start() {
//        super.start();
        System.out.println("부릉! 자동차가 출발합니다.");
    }
}
