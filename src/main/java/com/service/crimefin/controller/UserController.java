package com.service.crimefin.controller;

import com.service.crimefin.domain.MemberVO;
import com.service.crimefin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody HashMap<String, Object> requestJsonHashMap, HttpSession session) throws Exception{
        String memberId = (String) requestJsonHashMap.get("memberId");
        String password = (String) requestJsonHashMap.get("password");
        System.out.println("id : "+ memberId + " pw : "+ password);

        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId(memberId);
        memberVO.setPassword(password);
        MemberVO rvo = userService.login(memberVO);

        if (rvo != null) { //로그인 성공
            session.setAttribute("userInfo", rvo);
            return new ResponseEntity(rvo, HttpStatus.OK);
        } else { //로그인 실패
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    //여기서부턴 프론트엔드 작업 후 확인해보는 것 필요, postman은 동작
    @GetMapping(value = "/user", params = {"name", "phone"})
    public ResponseEntity findUserId(@RequestParam String name, @RequestParam String phone) throws Exception{

        MemberVO member = new MemberVO();
        member.setName(name);
        member.setPhone(phone);
        String memberId = userService.findMemberId(member);

        if(memberId != null) {
            return new ResponseEntity(memberId, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/user")
    public ResponseEntity registerUser(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception{
        MemberVO vo = new MemberVO();
        vo.setMemberId((String) requestJsonHashMap.get("memberId"));
        vo.setEmail((String) requestJsonHashMap.get("email"));
        vo.setPassword((String) requestJsonHashMap.get("password"));
        vo.setName((String) requestJsonHashMap.get("name"));
        vo.setPhone((String) requestJsonHashMap.get("phone"));
        vo.setAddress((String) requestJsonHashMap.get("address"));
        vo.setSex((int) requestJsonHashMap.get("sex"));
        vo.setMessageOk((int) requestJsonHashMap.get("messageOk"));

        //DB insert
        int result = userService.insertMember(vo);

        if(result != 0) {
            return new ResponseEntity(vo.getMemberId(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

}
