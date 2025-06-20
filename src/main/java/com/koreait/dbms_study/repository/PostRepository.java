package com.koreait.dbms_study.repository;

import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {

    @Autowired
    public PostMapper postMapper;

    public int addPost(Post post) {
        int result = postMapper.addPost(post);
        return result;
//        return postMapper.addPost(post);
    }

    public List<Post> getPostList() {
        return postMapper.getPostList();
    }
// 위와 동일
 //    public List<Post> getPostList() {
//        List<Post> postList =postMapper.getPostList();
//        return postList;
//    }


    public Optional<Post> getPostByPostId(Integer postId) {
        return postMapper.getPostByPostId(postId);
    }

    public int editPost(Post post) { // (포스트 객체)
        return postMapper.editPost(post);
    }

    public int removePost(Integer postId) {
        return postMapper.removePost(postId);
    }

//    public Optional<Post> getPostByUserId(Integer userId) {
//        return postMapper.getPostByUserId(userId);
//    }

}