package com.study.추상화_인터페이스_추상클래스;
// 추상 클래스 선언
public abstract class Animal {
    void eat() {
        System.out.println("음식을 먹습니다");
    }
    // 추상클래스를 extends 하면 꼭 구현해야하는 것
    public abstract void makeSound();
}
