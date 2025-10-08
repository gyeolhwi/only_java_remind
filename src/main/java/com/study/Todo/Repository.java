package com.study.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private Map<Long, Dto> database = new HashMap<>();
    // 새로운 데이터를 추가할 때 ID를 생성하기 위한 변수
    private long sequence = 0L;

    // 👇 이 블록이 추가되었습니다.
    // new Repository()가 실행될 때 이 안의 코드가 실행되어 더미 데이터가 추가됩니다.
    {
        database.put(1L, new Dto(1L, "자바 복습하기", false));
        database.put(2L, new Dto(2L, "스프링 부트 공부 시작", false));
        database.put(3L, new Dto(3L, "미니 프로젝트 구상", true));

        // 다음에 추가될 데이터의 ID가 4가 되도록 sequence 값을 맞춰줍니다.
        sequence = 3L;
    }

    public long save(Dto dto) {
        sequence++;
        Dto newDtoWithId = new Dto(sequence, dto.content(), dto.isDone());
        database.put(newDtoWithId.id(), newDtoWithId);
        return newDtoWithId.id();
    }

    public Dto get(Long id) {
        return database.get(id);
    }

    public List<Dto> getAll() {
        return new ArrayList<>(database.values());
    }

    public boolean update(Dto dto) {
        // 1. 수정하려는 데이터의 ID가 실제로 DB(Map)에 존재하는지 먼저 확인
        if (database.containsKey(dto.id())) {
            // 2. 존재할 경우에만 데이터를 덮어쓰고 true를 반환
            database.put(dto.id(), dto);
            // saveData(); // JSON 파일 저장 기능을 사용한다면 여기서 호출
            return true;
        } else {
            // 3. 존재하지 않으면 아무것도 하지 않고 false를 반환
            return false;
        }
    }

    public boolean delete(Long id) {
        return database.remove(id) != null;
    }
}
