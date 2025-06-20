package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.JpaPost;
import com.koreait.dbms_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

public class AddPostJpaRequestDto {
    @Data
    @AllArgsConstructor
    public class AddPostReqDto {
        private Integer userId;
        private String title;
        private String content;

        public JpaPost toEntity() {
            return JpaPost.builder()
                    .userId(this.userId)
                    .title(this.title)
                    .content(this.content)
                    .createdt(LocalDateTime.now())
                    .build();
        }
    }
}
