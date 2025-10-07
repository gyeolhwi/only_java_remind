package com.study.Todo;

public interface Service {
    public Dto addContent(String content);

    public Dto getContent(String id);

    public Dto getAllContent();

    public Dto updateContent(String id, String content);

    public Dto deleteContent(String id);
}
