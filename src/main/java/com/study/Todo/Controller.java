package com.study.Todo;

import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("명령어 입력\n 1. 추가\n 2. 단 건 조회\n 3.전체 조회 4.수정 5.삭제 6.종료");
        while (true) {
            System.out.println();
            System.out.println("""
                     1. 추가
                     2. 단 건 조회
                     3. 전체 조회
                     4. 수정
                     5. 삭제
                     6. 종료
                    """);
            int command = onlyNumber("명령어 선택:", scanner);
            if (command == 6) {
                System.out.println(">> 종료");
                break;
            }

            start(command, scanner);
        }
    }

    public static void start(int command, Scanner scanner) {
        int id;
        switch (command) {
            case 1:
                Create();
                break;
            case 2:
                id = onlyNumber("조회 할 ID 입력: ", scanner);
                Read(id);
                break;
            case 3:
                ReadList();
                break;
            case 4:
                id = onlyNumber("수정 할 ID 입력 ", scanner);
                if (id > 0) {
                    System.out.println("수정 할 컨텐츠를 입력 해주세요 : ");
                    scanner.nextLine();
                }
                break;
            case 5:
                id = onlyNumber("삭제 할 ID 입력: ", scanner);
                Delete(id);
                break;
            default:
                System.out.println("다시 시도 해주세요");
                break;
        }
    }

    private static void Create() {
        System.out.println("생성 동작");
    }

    private static Dto Read(int id) {
        System.out.println("조회 동작");
        return null;
    }

    private static List<Dto> ReadList() {
        System.out.println("전체 조회 동작");
        return null;
    }

    private static void Update() {
        System.out.println("수정 동작");
    }

    private static void Delete(int id) {
        System.out.println("삭제 동작");
    }


    private static int onlyNumber(String prompt, Scanner scanner) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(">> 오류: 숫자로만 입력해주세요");
            }
        }
    }


}
