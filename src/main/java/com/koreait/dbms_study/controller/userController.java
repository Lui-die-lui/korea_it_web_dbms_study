package com.koreait.dbms_study.controller;


import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.dto.EditUserReqDto;
import com.koreait.dbms_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// mybvatis
// SQL 중심의 데이터 접근 프레임 워크
// -> 내가 직접 SQL문 작성하고, 그 결과를  JAVA 객체로 매핑
// SQL을 직접짜기 때문에 완전히 통제 가능(자유도 높음), 대신 코드가 복잡하고 반복적이다.
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody AddUserReqDto addUserReqDto) {
        return ResponseEntity.ok(userService.addUser(addUserReqDto));
    }

    @GetMapping("/get/list")
    public ResponseEntity<?> getUserList() {
    return ResponseEntity.ok(userService.getUserList());
    }

//    @GetMapping("/get")
//    public ResponseEntity<?> getUserByUserId(@RequestParam Integer userId) {
//        return ResponseEntity.ok(userService.getUserByUserId(userId));
//    }
//    http://localhost:8080/user/get?userId=1
//    {"user":{"userid":1,"username":"이슬기","email":"test@example.com","createdt":"2025-06-18T21:17:43","updatedt":"2025-06-18T21:17:43"}}

    @GetMapping("/get/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getUserByUserId(userId));
    }
//    localhost:8080/user/get/1
//{
//    "user": {
//    "userId": 1,
//            "username": "이슬기",
//            "email": "test@example.com",
//            "createdt": "2025-06-18T21:17:43",
//            "updatedt": "2025-06-18T21:17:43"
//}
//}



   // 요청 메소드 중  DELETE< PUT 이 있는데 POST로
   // 보안상 이유(방화벽이 막아버릴 가능성 있음), 호환성 이유
   // 일부 브라우저, 서버가 PUT, DELETE를 완벽히 지원하지 않음
    // HTML <form> 가 GET, POST만 지원
    // - 조회 빼고 다 POST라고 생각하면 됨

    @PostMapping("/edit")
    public ResponseEntity<?> editUser(@RequestBody EditUserReqDto editUserReqDto) {
        return ResponseEntity.ok(userService.editUser(editUserReqDto));
    }

    @PostMapping("/remove") // body, param쓸 수 있음 but get에서는 param만 가능
    public ResponseEntity<?> removeUser(@RequestParam Integer userId) {
        return ResponseEntity.ok(userService.removeUser(userId));
    //localhost:8080/user/remove?userId=2
    }
}

