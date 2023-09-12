package com.service.crimefin.service;

import com.service.crimefin.domain.MemberVO;
import com.service.crimefin.model.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public MemberVO login(MemberVO memberVO) {
        return memberDAO.login(memberVO);
    }
}
