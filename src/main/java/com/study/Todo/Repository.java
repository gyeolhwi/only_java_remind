package com.study.Todo;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<Long, Dto> database = new HashMap<>();

    public boolean save(Dto dto) {
        return true;
    }

    public Dto get(Long id) {
        return null;
    }

    public boolean update(Dto dto) {
        return true;
    }

    public boolean delete(Long id) {
        return true;
    }
}
