package com.example.book.web.dto;

public class PostsUpdateResponseDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public PostsUpdateResponseDto(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
