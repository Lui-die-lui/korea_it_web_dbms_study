package com.koreait.dbms_study.service;

import com.koreait.dbms_study.dto.AddPostJpaRequestDto;
import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.ApiRespDto;
import com.koreait.dbms_study.dto.EditPostReqDto;
import com.koreait.dbms_study.entity.JpaPost;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.mapper.PostJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostJpaService {

    @Autowired
    private PostJpaRepository postJpaRepository;

    public JpaPost addPost(AddPostReqDto addPostReqDto) {
        return postJpaRepository.save(addPostReqDto.toJpaEntity());
    }

    public List<JpaPost> getPostList() {
        return postJpaRepository.findAll();
    }
//
//    public ApiRespDto<?> editPost(EditPostReqDto editPostReqDto) {
//        Optional<JpaPost> optionalJpaPost = postJpaRepository.findById(editPostReqDto.getPostId());
//        if (optionalJpaPost.isEmpty()) {
//        return new ApiRespDto<>("해당 게시물이 존재하지 않습니다.",null);
//    } try {
//            JpaPost jpaPost = optionalJpaPost.get();
//            jpaPost.setTitle(editPostReqDto.getTitle());
//            jpaPost.getContent(editPostReqDto.getContent());
//            jpaPost.setUpdatedt(LocalDateTime.now());
//            postJpaRepository.save(jpaPost);
////            return new ApiRespDto<>("게시물 수정 완료",editPost());
//        }catch (Exception e) {
//            return new ApiRespDto<>("문제가 발생했습니다.",e.getMessage());
//        }
//        }

    public ApiRespDto<?> removePost(Integer postId) {
        Optional<JpaPost> optionalJpaPost = postJpaRepository.findById(postId);
        if (optionalJpaPost.isEmpty()) {
        return new ApiRespDto<>("해당 게시물이 존재하지 않습니다.",null);
    } try {
            postJpaRepository.deleteById(postId);
        } catch (Exception e) {
            return new ApiRespDto<>("문제가 발생했습니다.",e.getMessage());
        }
        return new ApiRespDto<>("삭제 성공",null);
    }

}
