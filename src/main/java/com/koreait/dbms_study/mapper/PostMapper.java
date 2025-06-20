package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    public int addPost(Post post);
    List<Post> getPostList(); // 그냥 다 조회할거라서 매개변수 x
    Optional<Post> getPostByPostId(Integer postId);

//    Optional<Post> getPostByUserId(Integer userId);

    int editPost(Post post);

    int removePost(Integer postId);


}