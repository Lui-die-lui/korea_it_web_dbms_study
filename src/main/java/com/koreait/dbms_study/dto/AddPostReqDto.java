package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddPostReqDto {
    private Integer userId;
    private String title;
    private String content;

    public Post toEntity() {
        return Post.builder()
                .userId(this.userId)
                .title(this.title)
                .content(this.content)
                .build();
    }
}