package com.study.switch_패턴매칭_JDK21신기능;

public class Main {
    public static void main(String[] args) {
        System.out.println(getTypeInfo(10));
        System.out.println(getTypeInfo("test"));

        System.out.println(getTypeInfoWithSwitch(10));
        System.out.println(getTypeInfoWithSwitch("test"));
    }

    // 기존 type확인 방법
    public static String getTypeInfo(Object obj) {
        if (obj instanceof Integer) {
            return "Integer";
        } else if (obj instanceof String) {
            return "String";
        }
        return null;
    }
    // jdk21 부터 확인하는 switch 를 이용한 타입 확인 방법
    public static String getTypeInfoWithSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer";
            case String s -> "String";
            default -> "not find type";
        };
    }
}
