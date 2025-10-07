package com.study.레코드DTO만들기_JDK21신기능;

public class UserClass {
    private final String name;
    private final int age;

    // 생성자
    public UserClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Ctrl + O 자동완성 기능 메소드 생성
    @Override
    public String toString() {
        // 일일히 작성해줘야함
        return "UserClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        // equals()에서 비교에 사용한 필드들을 사용해서 고유한 숫자(해시코드)를 만듦
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        // 1. 메모리 주소가 같으면 당연히 같은 객체
        if (this == o) return true;

        // 2. 비교할 객체가 null이거나, 클래스 타입이 다르면 다른 객체
        if (o == null || getClass() != o.getClass()) return false;

        // 3. 다운캐스팅 후, 필드(내용)를 직접 비교
        UserClass userClass = (UserClass) o;
        if (age != userClass.age) return false;
        return name.equals(userClass.name);
    }
}
