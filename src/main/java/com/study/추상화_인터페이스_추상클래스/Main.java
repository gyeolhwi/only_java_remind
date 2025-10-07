package com.study.추상화_인터페이스_추상클래스;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        Dog dog = new Dog();
        dog.eat();
        dog.makeSound();
    }
}