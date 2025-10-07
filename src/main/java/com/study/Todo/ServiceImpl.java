package com.study.Todo;

public class ServiceImpl implements Service {

    // 의존성: Repository (변경 불가)
    private final Repository repository;

    // 생성자 주입: Repository 를 받아 객체를 초기화
    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Dto addContent(String content) {
        return null;
    }

    @Override
    public Dto getContent(String id) {
        return null;
    }

    @Override
    public Dto getAllContent() {
        return null;
    }

    @Override
    public Dto updateContent(String id, String content) {
        return null;
    }

    @Override
    public Dto deleteContent(String id) {
        return null;
    }
}
