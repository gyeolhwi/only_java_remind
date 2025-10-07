package com.study.상속_다형성;

public class Main {
    public static void main(String[] args) {
        // 부모 클래스로 선언 후 자식 클래스로 업 캐스팅
        Vehicle myCar = new Car();
        // 본인 클래스로 선언 후 그대로 사용 위와 동작은 같음
        Car childCar = new Car();
        myCar.start();
        childCar.start();
    }
}