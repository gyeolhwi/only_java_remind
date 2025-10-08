package com.study.Todo;

import java.util.List;

public interface Service {
    public long addContent(String content);

    public Dto getContent(long id);

    public List<Dto> getAllContent();

    public boolean updateContent(long id, String content);

    public boolean deleteContent(long id);
}
