package com.study.Todo;

import java.util.List;
import java.util.Optional;

public class ServiceImpl implements Service {

    // 의존성: Repository (변경 불가)
    private final Repository repository;

    // 생성자 주입: Repository 를 받아 객체를 초기화
    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public long addContent(String content) {
        Dto entity = new Dto(0L, content, false);
        return repository.save(entity);
    }

    @Override
    public Dto getContent(long id) {
        return repository.get(id);
    }

    @Override
    public List<Dto> getAllContent() {

        return repository.getAll();
    }

    @Override
    public boolean updateContent(long id, String content) {
        Dto existingDto = repository.get(id);
        if(existingDto == null){
            return false;
        }

        Dto updateDto = new Dto(existingDto.id(), content, existingDto.isDone());
        return repository.update(updateDto);
    }

    @Override
    public boolean deleteContent(long id) {
        return repository.delete(id);
    }
}
