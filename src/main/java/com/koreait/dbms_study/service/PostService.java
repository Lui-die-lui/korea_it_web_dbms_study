package com.koreait.dbms_study.service;


import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Map<String, String> addPost(AddPostReqDto addPostReqDto) {
        Map<String, String> response = new HashMap<>();
        int result = postRepository.addPost(addPostReqDto.toEntity());
        if (result == 1) {
            response.put("status","succes");
            response.put("message", "추가성공");
            return response;
        }
        response.put("status", "failed");
        response.put("message", "추가 실패");
        return response;
    }
}
