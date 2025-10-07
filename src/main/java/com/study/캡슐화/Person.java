package com.study.캡슐화;

public class Person {
    // 생성 후 직접 접근 불가
    private int age;

    // 함수를 이용해서만 불러오기 가능
    public int getAge() {
        return age;
    }

    // 함수를 이용해서만 수정 가능
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("유효하지 않은 나이 입니다.");
        }
    }
}
