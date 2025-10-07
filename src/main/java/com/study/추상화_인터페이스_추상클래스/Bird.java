package com.study.추상화_인터페이스_추상클래스;
// 인터페이스 구현
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("새가 날개짓하며 날아갑니다.");
    }


}
