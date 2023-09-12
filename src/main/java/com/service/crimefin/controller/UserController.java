package com.service.crimefin.controller;

import com.service.crimefin.domain.MemberVO;
import com.service.crimefin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception{
        String memberId = (String) requestJsonHashMap.get("memberId");
        String password = (String) requestJsonHashMap.get("password");
        System.out.println("id : "+ memberId + " pw : "+ password);

        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId(memberId);
        memberVO.setPassword(password);
        MemberVO rvo = userService.login(memberVO);

        if (rvo != null) { //로그인 성공
            return new ResponseEntity(rvo, HttpStatus.OK);
        } else { //로그인 실패
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

}
