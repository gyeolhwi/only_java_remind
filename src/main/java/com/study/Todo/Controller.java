package com.study.Todo;

import java.util.List;
import java.util.Scanner;

public class Controller {
    // Service와 Scanner를 모든 메소드에서 접근할 수 있도록 static(전역) 변수로 선언
    private static Service service;
    private static Scanner scanner;

    public static void main(String[] args) {
        // 프로그램 시작 시, static 변수들을 초기화
        Repository repository = new Repository();
        service = new ServiceImpl(repository);
        scanner = new Scanner(System.in);

        // 사용자가 '6. 종료'를 선택할 때까지 무한 루프
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

            int command = promptInt("명령어 선택: ");
            if (command == 6) {
                System.out.println(">> 프로그램을 종료합니다.");
                break;
            }

            // 입력받은 명령어에 따라 기능을 실행
            start(command);
        }
    }

    // start 메소드는 명령어에 따라 적절한 담당자(메소드)를 호출해주는 역할만 수행
    public static void start(int command) {
        switch (command) {
            case 1:
                handleCreate();
                break;
            case 2:
                handleReadOne();
                break;
            case 3:
                handleReadList();
                break;
            case 4:
                handleUpdate();
                break;
            case 5:
                handleDelete();
                break;
            default:
                System.out.println(">> 1~6 사이의 숫자를 입력해주세요.");
                break;
        }
    }

    // --- 각 기능을 담당하는 private 헬퍼 메소드들 ---

    private static void handleCreate() {
        System.out.print("추가할 할 일 내용: ");
        String content = scanner.nextLine();
        System.out.println("id : " + service.addContent(content));
        System.out.println(">> 성공적으로 추가되었습니다.");
    }

    private static void handleReadOne() {
        int id = promptInt("조회할 ID 입력: ");
        Dto dto = service.getContent(id);
        if (dto != null) {
            System.out.println(">> 조회 결과: " + dto);
        } else {
            System.out.println(">> 해당 ID의 할 일이 없습니다.");
        }
    }

    private static void handleReadList() {
        List<Dto> dtoList = service.getAllContent();
        System.out.println("\n--- 전체 할 일 목록 ---");
        if (dtoList.isEmpty()) {
            System.out.println(">> 저장된 할 일이 없습니다.");
        } else {
            dtoList.forEach(System.out::println);
        }
        System.out.println("----------------------");
    }

    private static void handleUpdate() {
        int id = promptInt("수정할 ID 입력: ");
        System.out.print("새로운 내용 입력: ");
        String content = scanner.nextLine();
        boolean isSuccess = service.updateContent(id, content);
        if (isSuccess) {
            System.out.println(">> " + id + "번 할 일이 수정되었습니다.");
        } else {
            System.out.println(">> 실패 다시 시도");
        }
    }

    private static void handleDelete() {
        int id = promptInt("삭제할 ID 입력: ");
        boolean isSuccess = service.deleteContent(id);
        if (isSuccess) {
            System.out.println(">> 삭제 완료");

        } else {
            System.out.println("id 확인");
        }
    }

    // 사용자에게 숫자를 입력받는 역할을 담당하는 헬퍼 메소드
    private static int promptInt(String prompt) {
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