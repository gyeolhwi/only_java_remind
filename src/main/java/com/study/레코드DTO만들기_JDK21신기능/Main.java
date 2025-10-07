package com.study.레코드DTO만들기_JDK21신기능;

public class Main {
    public static void main(String[] args) {
        // 생성자 때 의존성 부여로 값 지정해줘야함
        UserClass user1 = new UserClass("홍길동", 30);
        UserRecord user2 = new UserRecord("김철수", 25);
        System.out.println(user1);
        System.out.println(user2);
    }
}
