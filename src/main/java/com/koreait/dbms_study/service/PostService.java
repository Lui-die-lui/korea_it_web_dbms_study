package com.koreait.dbms_study.service;

import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.ApiRespDto;
import com.koreait.dbms_study.dto.EditPostReqDto;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.repository.PostRepository;

import com.koreait.dbms_study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> addPost(AddPostReqDto addPostReqDto) {
        Map<String, String> response = new HashMap<>();
        int result = postRepository.addPost(addPostReqDto.toEntity());

//    public ApiRespDto<?> addPost(AddPostReqDto addPostReqDto) {
//        try {
//          Optional<User> optionalUser = userRepository.getUserByUserId(addPostReqDto.getUserId());
//          if(optionalUser.isEmpty()) {
//              return new ApiRespDto<>("존재하지 않는 유저입니다.",null);
//          }
//          int result = postRepository.addPost(addPostReqDto.toEntity());
//
//          if (result == 0) {
//              return new ApiRespDto<>("문제가 발생했습니다.",null);
//          }
//          return new ApiRespDto<>("정상적으로 게시하였습니다.",null);
//        } catch (Exception e) {
//            return new ApiRespDto<>("문제가 발생했습니다.",e.getMessage());
//        } -- 나중에 보기

        if (result == 1) {
            response.put("status", "success");
            response.put("message", "추가 성공");
            return response;
        }
        response.put("status", "failed");
        response.put("message", "추가 실패");
        return response;
    }

//    public List<Post> getPostList() {
//        return postRepository.getPostList();
//    }

    public ApiRespDto<?> getPostList() {
        try {
            List<Post> postList = postRepository.getPostList();
            return new ApiRespDto<>("조회 완료",postList);
        } catch (Exception e) {
            return new ApiRespDto<>("문제가 발생했습니다.", e.getMessage());
        }
    }

//    public Map<String, Object> getPostByPostId(Integer postId) {
//        Map<String, Object> response = new HashMap<>();
//        Optional<Post> post = postRepository.getPostByPostId(postId);
//        if(post.isEmpty()) {
//            response.put("message","포스트가 없습니다.");
//            return response;
//        }
//        response.put("post",post);
//        return response;
//    }
    public ApiRespDto<Object> getPostByPostId(Integer postId) {
        try {
            Optional<Post> optionalPost = postRepository.getPostByPostId(postId);
            if (optionalPost.isEmpty()) {
                return new ApiRespDto<>("해당 게시물이 없습니다.", null);
            }
            return new ApiRespDto<>("조회 성공", optionalPost.get());
        } catch (Exception e) {
            return new ApiRespDto<>("문제가 발생했습니다.", e.getMessage());
        }

    }

//    public ApiRespDto<Post> editPost(EditPostReqDto editPostReqDto) {
//        Optional<Post> post = postRepository.getPostByPostId(editPostReqDto.getPostId());
//        if (post.isEmpty()) {
//            return new ApiRespDto<>("해당 포스트가 존재하지 않습니다.",null);
//        }
//        int result = postRepository.editPost(editPostReqDto.toEntity());
//        if (result == 0) {
//            return new ApiRespDto<>("문제가 발생했습니다.",null);
//        }
//        return new ApiRespDto<>("성공적으로 수정이 완료되었습니다.",null);
//    }



    public ApiRespDto<?> editPost(EditPostReqDto editPostReqDto) {
        try {
            Optional<Post> optionalPost = postRepository.getPostByPostId(editPostReqDto.getPostId());
        if (optionalPost.isEmpty()) {
            return new ApiRespDto<>("해당 게시물은 존재하지 않습니다.",null);
        }
        int result = postRepository.editPost(editPostReqDto.toEntity());
        if (result != 1) {
            return new ApiRespDto<>("문제가 발생했습니다.",result);
        }
        return  new ApiRespDto<>("수정 성공",result);
        } catch (Exception e) {
            return new ApiRespDto<>("문제가 발생했습니다.",e.getMessage());
        }
    }


    public ApiRespDto<Integer> removePost(Integer postId) {
        Optional<Post> post = postRepository.getPostByPostId(postId);
        if (post.isEmpty()) {
            return new ApiRespDto<>("해당 포스트가 존재하지 않아 작업을 실행할 수 없습니다.",null);
        }
        int result = postRepository.removePost(postId);
        if (result == 0) {
            return new ApiRespDto<>("문제가 발생했습니다.",result);
        }
        return new ApiRespDto<>("포스트 삭제 완료",result);
    }

    // 마지막꺼 나중에 선생님 github 볼것! try-catch

}