package com.koreait.dbms_study.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiRespDto<T> {
    private String message;
    private T data; // 제네릭으로 나중에 명시
}
