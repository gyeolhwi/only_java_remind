package com.study.캡슐화;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(30);
        System.out.println(p.getAge());
        p.setAge(-5);
        System.out.println(p.getAge());
    }
}
